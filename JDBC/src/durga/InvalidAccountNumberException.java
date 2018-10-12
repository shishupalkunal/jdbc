package durga;

public class InvalidAccountNumberException extends Exception {
  int accno;
  public InvalidAccountNumberException() {
	}
	public InvalidAccountNumberException(int da) {
		this.accno=accno;
	}
	public String toString() {
		return "Accno:"+accno+"is Not Found";
	}

}
