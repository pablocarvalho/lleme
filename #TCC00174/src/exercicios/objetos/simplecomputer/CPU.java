/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe CPU
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

public class CPU {

  private final int READ = 10; //> Comando de leitura
  private final int WRITE = 11; //> Comando de escrita
  private final int LOAD = 20; //> Comando de carregamento
  private final int STORE = 21; //> Comando de salvamento
  private final int ADD = 30; //> Comando de Adição
  private final int SUB = 31; //> Comando de Subtração
  private final int MUL = 32; //> Comando de Multiplicação
  private final int DIV = 33; //> Comando de Divisão
  private final int MOD = 34; //> Comando de Resto da divisão
  private final int BRANCH = 40; //> Altera o fluxo
  private final int BRANCHNEG = 41; //> Altera o fluxo
  private final int BRANCHZERO = 42; //> Altera o fluxo
  private final int HALT = 43; //> Encerra a execução
  private int instructionCounter;    //> Contador de instruções
  private int programCounter;        //> Contador de programa
  private int accumulator;           //> Acumulador
  private InputDevice inputDevice;  //> Dispositivo de entrada
  private OutputDevice outputDevice; //> Dispositivo de saida
  private Memory memory;             //> Memória do computador

  /**
   * Construtor.
   *
   * @param inoutDevice Dispositivo de entrada.
   * @param outputDevice Dispositico de saída.
   * @param memory Memória do computador
   */
  CPU(InputDevice inputDevice, OutputDevice outputDevice, Memory memory) {
    accumulator = 0;
    instructionCounter = 0;
    programCounter = 0;
    this.inputDevice = inputDevice;
    this.outputDevice = outputDevice;
    this.memory = memory;
  }

  /**
   * Acesso ao contador de instruções
   *
   * @return instrução corrente
   */
  public int getInstructionCounter() {
    return instructionCounter;
  }

  /**
   * Atribução do contador de instruções
   *
   * @param ic instrução corrente
   */
  public void setInstructionCounter(int ic) {
    this.instructionCounter = ic;
  }

  /**
   * Acesso ao contador de programas
   *
   * @return proxima instrução a ser executada
   */
  public int getProgramCounter() {
    return programCounter;
  }

  /**
   * Acesso ao contador de programas
   *
   * @param pc proxima instrução a ser executada
   */
  public void setProgramCounter(int pc) {
    this.programCounter = pc;
  }

  /**
   * Incrementa o endereço do contador de programas
   */
  public void incProgramCounter() {
    programCounter++;
  }

  /**
   * Acesso ao acumulador
   *
   * @return o valor do acumulador
   */
  public int getAccumulator() {
    return accumulator;
  }

  /**
   * Atribuição do acumulador
   *
   * @param o novo valor do acumulador
   */
  public void setAccumulator(int ac) {
    this.accumulator = ac;
  }

  /**
   * Decodificação do Opcode
   *
   * @param word paravra a ser decodificada
   */
  public Opcode decodifyInstruction(int word) {

    Opcode opcode = new Opcode();
    if (word / 100 == 0) {
      opcode.setInstructionCode(word % 100);
      opcode.setOperandSpecifier(0);
    } else {
      opcode.setInstructionCode(word / 100);
      opcode.setOperandSpecifier(word % 100);
    }

    return opcode;
  }

  /**
   * Executa o programa
   *
   * @param address posição inicial do programa
   */
  public void run(int address) {

    setProgramCounter(address);
    Opcode opcode;

    do {
      int word = memory.getWord(getProgramCounter());
      setInstructionCounter(word);
      opcode = decodifyInstruction(getInstructionCounter());

      switch (opcode.getInstructionCode()) {
        case READ:
          accumulator = inputDevice.readInt();
          incProgramCounter();
          break;
        case WRITE:
          outputDevice.writeInt(accumulator);
          incProgramCounter();
          break;
        case LOAD:
          accumulator = memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case STORE:
          memory.setWord(opcode.getOperandSpecifier(), accumulator);
          incProgramCounter();
          break;
        case ADD:
          accumulator += memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case SUB:
          accumulator -= memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case MUL:
          accumulator *= memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case DIV:
          accumulator /= memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case MOD:
          accumulator %= memory.getWord(opcode.getOperandSpecifier());
          incProgramCounter();
          break;
        case BRANCH:
          setProgramCounter(opcode.getOperandSpecifier());
          break;
        case BRANCHZERO:
          if (accumulator == 0)
            setProgramCounter(opcode.getOperandSpecifier());
          else
            incProgramCounter();
          break;
        case BRANCHNEG:
          if (accumulator < 0)
            setProgramCounter(opcode.getOperandSpecifier());
          else
            incProgramCounter();
          break;
        case HALT:
          break;
        default:
          System.out.println("Invalid instruction");
          System.out.println("Program aborted");
          opcode.setInstructionCode(HALT);
          break;
      }

    } while (opcode.getInstructionCode() != HALT);
  }
}
