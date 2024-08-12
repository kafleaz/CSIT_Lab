/* Write a program that asks user for a key and plain text and displays the corressponding Vigenere cipher*/

#include <iostream>
#include <string>
using namespace std;
string vigenereEncrypt(const string& key, const string& plaintext) {
    string ciphertext = "";
    int keyLength = key.length();
    int index = 0;

    for (char ch : plaintext) {
        if (isalpha(ch)) {
            char base = isupper(ch) ? 'A' : 'a';
            char shift = key[index % keyLength];
            shift = isupper(shift) ? shift - 'A' : shift - 'a';
            ciphertext += static_cast<char>((ch - base + shift + 26) % 26 + base);
            index++;
        } else {
            ciphertext += ch;
        }
    }
    return ciphertext;
}
int main() {
    string key, plaintext;

    cout << "Enter the key: ";
    cin >> key;

    cout << "Enter plaintext: ";
    cin.ignore();
    getline(cin, plaintext);

    string encryptedMessage = vigenereEncrypt(key, plaintext);
    cout << "Cipher: " << encryptedMessage << endl;

    return 0;
}
