// Implement the IDEA key scheduling algorithm to generate subkeys from the main encryption key.
#include<iostream>
#include<string>
#include<bitset>

using namespace std;

const int KEY_SIZE = 128;
const int ROUNDS = 8;

// IDEA round keys as strings
string subkeys[ROUNDS][6];

// Function to rotate a string left by n bits
string rotateLeft(const string& str, int n) {
    return str.substr(n) + str.substr(0, n);
}
// IDEA key scheduling function
void IDEA_key_schedule(string main_key) {
    for (int round = 0; round < ROUNDS; ++round) {
        for (int i = 0; i < 6; ++i) {
            subkeys[round][i] = main_key.substr(0, 16);
            main_key = rotateLeft(main_key, 25);
        }
    }
}

string TextToBinaryString(string words)
{
    string binaryString = "";
    for (char& _char : words) {
        binaryString +=bitset<8>(_char).to_string();
    }
    return binaryString;
}

int main() {
    
    string main_key, key_bin;
    cout << "Enter the key to encrypt" << endl;
    cin >> main_key;
    key_bin = TextToBinaryString(main_key).substr(0, 128);
    IDEA_key_schedule(key_bin);
    // Output the generated subkeys
    cout << "Generated Subkeys:" << endl;
    for (int round = 0; round < ROUNDS; ++round) {
        cout << "Round " << round + 1 << ": ";
        for (int i = 0; i < 6; ++i) {
            cout << subkeys[round][i] << " ";
        }
        cout << endl;
    }
    return 0;
}
