package uff.ic.lleme.tic10002.trabalhos.s20171.Daniel_Bastos;

class HashTable {

    // Knuth [em The Art of Computer Programming, volume 3,
    // capítulo 6.4 ``HASHING'', página 516] afirma que o número
    // primo 1009 ``has been found to be quite satisfactory in most cases.''
    private final static int SIZE = 1009;

    HashItem[] table;

    HashTable() {
        table = new HashItem[SIZE];
        for (int i = 0; i < SIZE; i++)
            table[i] = null;
    }

    public Object get(int key) {
        int hash = hashIt(key);
        if (table[hash] == null)
            return null;
        else {
            HashItem entry = table[hash];
            while (entry != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry == null)
                return null;
            else
                return entry.getVal();
        }
    }

    public void set(int key, Object val) {
        int hash = hashIt(key);
        if (table[hash] == null)
            table[hash] = new HashItem(key, val);
        else {
            HashItem entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();
            if (entry.getKey() == key)
                entry.setVal(val);
            else
                entry.setNext(new HashItem(key, val));
        }
    }

    public void remove(int key) {
        int hash = hashIt(key);
        if (table[hash] != null) {
            HashItem prevEntry = null;
            HashItem entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key)
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
        }
    }

    public int hashIt(int key) {
        return key % SIZE;
    }

    class HashItem {

        private final int key;
        private Object val;
        private HashItem next;

        HashItem(int key, Object val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object v) {
            val = v;
        }

        public int getKey() {
            return key;
        }

        public HashItem getNext() {
            return next;
        }

        public void setNext(HashItem n) {
            next = n;
        }
    }
}
