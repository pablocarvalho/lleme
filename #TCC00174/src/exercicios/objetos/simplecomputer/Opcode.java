/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Opcode
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

public class Opcode {

  private int instructionCode;
  private int operandSpecifier;

  public int getInstructionCode() {
    return instructionCode;
  }

  public void setInstructionCode(int instructionCode) {
    this.instructionCode = instructionCode;
  }

  public int getOperandSpecifier() {
    return operandSpecifier;
  }

  public void setOperandSpecifier(int operandSpecifier) {
    this.operandSpecifier = operandSpecifier;
  }
}
