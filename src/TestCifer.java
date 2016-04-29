

import java.util.Arrays;

public class TestCifer {

	public static void main(String[] args) {
		//testSimpleCripto();
		System.out.println("\n\n\n");
		testAsymCripto();
	}

	/**
	 * Simétrica 
	 */
	public static void testSimpleCripto() {
		System.out.println("---Criptografia Simétrica---");
		String msgToSend = "OLA GALERA DA COMP";
		System.out.println("Mensagem original a ser enviada: "+msgToSend);
		
		byte key[] = { (byte) 0xF2 , (byte) 0xD4, (byte) 0x94 , (byte) 0x44}; //chave usada para encriptar e decriptar
		
		Cipher c = new Cipher();
		c.setPublicKey(key);

		byte[] criptedMsg = c.cript(msgToSend);
		System.out.println("Mensagem após aplicada a criptografia: "+Arrays.toString(criptedMsg));

		
		byte[] decriptedMsg = c.decript(criptedMsg);
		System.out.println("Mensagem descriptada a partir da msg encriptada: "+new String(decriptedMsg));
	}

	public static void testAsymCripto() {

		System.out.println("---Criptografia Assimétrica---");
		//Cria cada cliente e sua msg
		String msgA = "Oi Person B";
		Person A = new Person(msgA);
		
		
		String msgB = "Eai A, blz?";
		Person B = new Person(msgB);
		
		System.out.println("Publica de A:"+A.publicKey);
		System.out.println("Publica de B:"+B.publicKey);
		//trocam as chaves publicas/hash com a conta efetuada
		A.changePublicWith(B);

		//A encripta, ja com tudo feito
		byte[] msgAEncripted = A.getEncriptedMsg();
		System.out.println("A encripta sua msg: "+ new String(msgAEncripted));
		
		//B recebe a msg e desencripta
		byte[] originalMsgA = B.receiveEncriptedMsgAndDesencript(msgAEncripted);
		System.out.println("B recebe a mensagem de A encripatada e a decripta: "+new String(originalMsgA)); 
		
		
		//B pega a mensagem própria e encripta
		byte[] msgBEncripted =B.getEncriptedMsg();
		System.out.println("B encripta sua msg: "+new String( msgBEncripted));
		//A pega a mensgem encriptada e desencripta 
		byte[] originalMsgB = B.receiveEncriptedMsgAndDesencript(msgBEncripted);
		System.out.println("A recebe a mensagem de B encripatada e a decripta: "+new String(originalMsgB)); 

	}
}
