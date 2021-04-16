package hw1;

public class VigenereKey
{
	private String keyword;
	
	public VigenereKey()
	{
		keyword = "";
	}

	public VigenereKey(String keyword)
	{
		this.keyword = keyword;
	}

	public String generateKey(String str)
	{
		str.toLowerCase();
		String key = "";
		int k = 0;
		for (int i = 0; i < str.length(); i++)
		{
				key += keyword.charAt(k);
				if (k == keyword.length() - 1)
				{
					k = 0;
				}
				else
				{
					k++;
				}
		}
		return key;
	}

	public String encrypt(String plainText)
	{
		plainText.toLowerCase();
		String key = generateKey(plainText);
		String encryptedText = "";
		String[] encryptedNum = new String[plainText.length()];
		String[] nums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < plainText.length(); i++)
		{
				char a = plainText.charAt(i);
				char b = key.charAt(i);
				encryptedNum[i] = Integer.toString(((Character.getNumericValue(a) + Character.getNumericValue(b)) - 20) % 26);
		}
		for (int i = 0; i < encryptedNum.length; i++)
		{
				for (int j = 0; j < 26; j++)
				{
					if (encryptedNum[i].equals(nums[j]))
					{
						encryptedText += chars[j];
					}
				}
		}
		return encryptedText;
	}

	public String decrypt(String encryptedText)
	{
		encryptedText.toLowerCase();
		String key = generateKey(encryptedText);
		String decryptedText = "";
		String[] decryptedNum = new String[encryptedText.length()];
		String[] nums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = 0; i < encryptedText.length(); i++)
		{
				char a = encryptedText.charAt(i);
				char b = key.charAt(i);
				decryptedNum[i] = Integer.toString(((Character.getNumericValue(a) - Character.getNumericValue(b)) +26 -20) % 26);
		}
		for (int i = 0; i < decryptedNum.length; i++)
		{
				for (int j = 0; j < 26; j++)
				{
					if (decryptedNum[i].equals(nums[j]))
					{
						decryptedText += chars[j];
					}
				}
		}
		return decryptedText;
	}
}
