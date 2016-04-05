

import java.util.Random;

public class Person {
	String msg;
	Cipher c = new Cipher();

	public Person(String msgA) {
		calculatePublic();
		msg = msgA;
	}

	public int publicKey;
	public int otherPersonKey;
	public int hash;

	public int privateKey = new Random().nextInt((100 - 1) + 1) + 1;

	public void calculatePublic() {
		publicKey = privateKey * 0xC1;
	}

	public void changePublicWith(Person personB) {
		setOtherPublicKey(personB.publicKey);
		personB.setOtherPublicKey(publicKey);
	}

	public void setOtherPublicKey(int otherPersonKey) {
		this.hash = otherPersonKey * privateKey;
		c.setPublicKey(this.hash);
	}

	public byte[] getEncriptedMsg() {
		return c.cripto(msg);
	}

	public byte[] receiveEncriptedMsgAndDesencript(byte[] encriptedMsg) {
		return c.descripto(encriptedMsg);

	}
}
