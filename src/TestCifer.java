

import java.util.Arrays;

public class TestCifer {

	public static void main(String[] args) {
		testAsymCripto();
	}

	public static void testSimpleCripto(String msg) {

		msg = "OLA GALERA DA COMP";
		Cipher c = new Cipher();

		byte[] criptedMsg = c.cripto(msg);
		System.out.println(criptedMsg.length);
		System.out.println(Arrays.toString(criptedMsg));

		byte[] originalMsg = c.descripto(criptedMsg);
		System.out.println(Arrays.toString(criptedMsg));
		System.out.println(new String(originalMsg));
		return;
		//
		// if (msg.equals(originalMsg)) {
		// System.out.println("AEEEE");
		// } else {
		// System.out.println("DEU RUIM");
		// }
		// System.out.println("Original " + originalMsg);

	}

	public static void testAsymCripto() {

		String msgA = "Oi Person B";
		String msgB = "Eai Cara, blz?";
		//Cria cada cliente
		Person A = new Person(msgA);
		Person B = new Person(msgB);
		//trocam as chaves publicas
		A.changePublicWith(B);

		System.out.println(A.hash);
		System.out.println(B.hash);
		//A encripta, ja com tudo feito
		byte[] msgAEncripted = A.getEncriptedMsg();
		
		//B recebe a msg e desencripta
		byte[] originalMsg = B.receiveEncriptedMsgAndDesencript(msgAEncripted);
		System.out.println(new String(originalMsg)); 
		
		
		//B pega a mensagem própria e encripta
		byte[] msgBEncripted =B.getEncriptedMsg();
		//A pega a mensgem encriptada e desencripta 
		byte[] originalMsgB = B.receiveEncriptedMsgAndDesencript(msgBEncripted);
		System.out.println(new String(originalMsgB));

	}
}
