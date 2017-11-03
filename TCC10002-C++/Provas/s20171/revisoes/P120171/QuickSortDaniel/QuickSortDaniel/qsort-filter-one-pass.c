#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <stdint.h>
#include <libgen.h>
#include <stdarg.h>

static char *program;

/* declarations */

typedef struct element {
  void *data;
  struct element *next;
} Element;

#define List Element

List* cons(void *data, size_t size_of_data, List *ls);
void* first(List *ls);
List* rest(List *ls);
int length(List *ls);
void destroy(List *ls);

#define EMPTY NULL
#define IS_EMPTY(list) (list) == NULL ? 1 : 0

List* reverse(List *ls);

List* concat(List *ls1, List *ls2, List *ls3);
List* append(List *ls1, List *ls2);
List* slice(List *ls, int begin, int end);

Element* nth(List *ls, int n);
Element* last(List *ls);

List* drop(List *ls, int n);
List* take(List *ls, int n); /* int32_take() */

List* int32_makelist(char *a[], size_t len, char *prefix);
void int32_print(List *ls);

void strerr(char *s);
void strerr_die(int e, char *s);
void strerr_sys(int e);

/* warning: anonymous variadic macros were introduced in C99 [-Wvariadic-macros] */
#define fatal(exitcode, fmt, ...) fatal_f(exitcode, fmt"\n", ##__VA_ARGS__)

void fatal_f(int exitcode, const char *fmt, ...)
    __attribute__((format (printf, 2, 3)));

List* int32_qsort(List *ls);

/* quicksort */
void int32_filter_one_pass(int32_t pivot, List *ls, List **smaller, List **larger)
{
  int32_t *n; Element *cur;

  cur = ls;

  while (cur) {
    n = cur->data;
    if (*n <= pivot)
      *smaller = cons(n, sizeof *n, *smaller);
    if (*n > pivot)
      *larger = cons(n, sizeof *n, *larger);
    cur = cur->next;
  }
}

List* int32_qsort(List *ls)
{
  int32_t *pivot; List *smaller; List *larger;
  smaller = larger = EMPTY;

  if (IS_EMPTY(ls)) return EMPTY;

  pivot = first(ls);
  int32_filter_one_pass(*pivot, rest(ls), &smaller, &larger);

  return concat(int32_qsort(smaller),
                cons(pivot, sizeof (int32_t), EMPTY), 
                int32_qsort(larger));
}

/* end of quicksort */

void usage()
{
  printf("usage: %s z(1) [z(2) z(3) z(4) ... z(n)]\n", basename(program));
  printf("usage:   where z(i) is an integer\n");
  exit(0);
}

int scan_int32(char *s, int32_t *u) 
{
  unsigned int pos;
  int32_t r;
  unsigned int c;
  int m = 1;

  pos = 0; r = 0;

  if (s[pos] == '-') { /* negative number */
    m = -1; ++pos;
  }

  for ( ;; ) {
    c = (unsigned int) (unsigned char) (s[pos] - '0');
    if (c > 10)
      break;

    if( (INT32_MAX - c)/10 < r) {
      if (m < 0) return -1; /* underflow */ else return -2; /* overflow */
    }

    r = r * 10 + c;
    ++pos; continue;
  }

  *u = r * m;
  return pos;
}

/*
  (ARRAY-of CHAR) NATURAL --> LIST

  Takes an array of chars a, the size of the array len and produces a
  list of int32_t converted from a.  To avoid a list in reverse order,
  we scan the array backwards.
*/
List* int32_makelist(char *a[], size_t len, char *prefix)
{
  List *ls = EMPTY; 
  int i;

  for (i = len - 1; i >= 0; --i) {
    int32_t u; int r;
    r = scan_int32(a[i], &u);

    if (r == -1) {
      printf("%s: %s: underflow: least value: -(2^31 - 1); ignoring it.\n", 
             prefix, a[i]);
      continue;
    }

    if (r == -2) {
      printf("%s: %s: overflow: greatest value: 2^31 - 1; ignoring it.\n", 
             prefix, a[i]);
      continue;
    }

    if (r == 0 || r < strlen(a[i])) {
      printf("%s: ``%s'' not an integer; ignoring it.\n", 
             prefix, a[i]);
      continue;
    }

    ls = cons(&u, sizeof u, ls);
  }

  return ls;
}

void int32_print(List *ls)
{
  int *data;

  if (ls == EMPTY) { printf("\n"); return; }

  data = first(ls);

  printf("%d ", *data);
  int32_print(rest(ls));
}

int main(int argc, char *argv[])
{
  program = argv[0];

  if (argc < 2)
    usage();
  
  int32_print(int32_qsort(int32_makelist(argv + 1, argc - 1, basename(program))));
  return 0;
}

void destroy(List *ls)
{
  if (IS_EMPTY(ls)) return;

  destroy(rest(ls));
  
  free(first(ls)); /* frees the data first */
  free(ls->next); /* now the element */
}

/* library */
void strerr(char *s)
{
  if (s)
    fprintf(stdout, "%s\n", s);
}

void strerr_die(int e, char *s)
{
  if (s)
    fprintf(stdout, "%s\n", s);
  exit(e);
}

void strerr_sys(int e)
{
  strerr_die(e, strerror(errno));
}

void fatal_f(int exitcode, const char *fmt, ...) 
{
    va_list arg;
    va_start(arg, fmt);
    vfprintf(stdout, fmt, arg);
    va_end(arg);
    exit(exitcode);
}

List* cons(void *data, size_t size_of_data, List* ls)
{
  Element* e; void* copy_of_data;
  e = malloc(sizeof (Element));
  if (e == NULL)
    fatal(6, "cons: out of memory.");

  copy_of_data = malloc(size_of_data);
  if (copy_of_data == NULL)
    fatal(6, "cons: out of memory.");

  memset(copy_of_data, '\0', size_of_data);
  memcpy(copy_of_data, data, size_of_data);

  e->data = copy_of_data; 
  e->next = ls; /* new element is the head */
  return e;
}

void* first(List *ls)
{
  return ls->data;
}

List* rest(List *ls)
{
  return ls->next;
}

int length(List *ls)
{
  if (IS_EMPTY(ls)) return 0;

  return 1 + length(rest(ls));
}

Element* last(List *ls)
{
  Element *ret = ls;

  while (ret && ret->next)
    ret = ret->next;

  return ret;
}

List* append(List *ls1, List *ls2)
{
  if (IS_EMPTY(ls1)) return ls2;
  if (IS_EMPTY(ls2)) return ls1;

  last(ls1)->next = ls2;
  return ls1;
}

List* concat(List *ls1, List *ls2, List *ls3)
{
  return append(ls1, append(ls2, ls3));
}

