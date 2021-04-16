package hw1;

public class VigenereTester
{
	public static void main(String[] args)
	{		
		String plainText = "HellenismwasthecombinationofGreekPersian"
				+ "andEgyptianculturesDuringthisremarkabletimeperiodpeople" 
				+ "wereencouragedtopursueaformaleducationandproducemany"
				+ "differentkindsofartNewformsofmathscience" 
				+ "anddesignmadeagreatimpactonsociety";
		String keyword = "cat";
		VigenereKey Vk = new VigenereKey(keyword);
		String encryptedText = Vk.encrypt(plainText);
		String decryptedText = Vk.decrypt(encryptedText);
		System.out.println("Cipher text: " + encryptedText);
		System.out.println("Decrypted text: " + decryptedText);
	}
}
