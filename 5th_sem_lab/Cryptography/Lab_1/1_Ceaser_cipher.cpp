/* Write a program that takes an integer value k(i.e. shift value between +/-26) and a plaintext message and returns a coressponding Caeser cipher. The program should also implement 
a decryption routine that reconstructs the original plaintext from the ciphertext. */

#include <iostream>
#include <string>

using namespace std;

string caesarEncrypt(int k, const string& plaintext) 
{
    string ciphertext = "";
    for (char ch : plaintext) 
	{
        if (isalpha(ch)) 
		{
            char base = isupper(ch) ? 'A' : 'a';
            ciphertext += static_cast<char>((ch - base + k + 26) % 26 + base);
        } 
		else 
		{
            ciphertext += ch;
        }
    }
    return ciphertext;
}

string caesarDecrypt(int k, const string& ciphertext) {
    return caesarEncrypt(-k, ciphertext); // Decryption is just encryption with negative shift.
}

int main() {
    int shiftValue;
    string message;

    cout << "Enter shift value (1 - 26): ";
    cin >> shiftValue;

    if (shiftValue < -26 || shiftValue > 26) {
        cout << "Invalid shift value. Enter a value between 1 to 26." << endl;
        return 1;
    }

    cin.ignore(); 
    cout << "Enter plaintext: ";
    getline(cin, message);

    string encryptedMessage = caesarEncrypt(shiftValue, message);
    cout << "Cipher text: " << encryptedMessage << endl;

    string decryptedMessage = caesarDecrypt(shiftValue, encryptedMessage);
    cout << "Decrypted plaintext: " << decryptedMessage << endl;

    return 0;
}
