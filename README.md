# Bayside High School Project
# File Encryption/Decryption Program

A Java-based command-line utility for encrypting and decrypting files using a custom multi-step encryption algorithm.

## Features

- File encryption with password protection
- File decryption using the same password
- Multi-step encryption algorithm including:
  - Character skipping
  - ASCII conversion
  - String flipping
  - Binary conversion
  - Custom number substitution
  - And more...

## Prerequisites

- Java Runtime Environment (JRE) installed on your system
- Basic knowledge of command-line operations

## Usage

### Running the Program

1. Compile the Java files:
```bash
javac Main.java Input.java
```

2. Run the program:
```bash
java Main
```

### Menu Options

1. **Encrypt** - Encrypt a file
   - Enter source filename
   - Enter destination filename
   - Set a 4-digit password (remember this for decryption)

2. **Decrypt** - Decrypt a file
   - Enter encrypted filename
   - Enter destination filename
   - Enter the original 4-digit password

3. **Exit** - Close the program

### Important Notes

- The password must be exactly 4 digits (0-9)
- Store your password safely - there's no way to decrypt files without it
- Input files must be in the same directory as the program
- Output files will be created in the same directory

## Security Features

The encryption process includes multiple steps:
- Character scrambling using skip patterns
- ASCII conversion with padding
- String manipulation and flipping
- Numeric transformations
- Binary encoding
- Random number substitution

## Limitations

- Only works with text files
- Password must be exactly 4 digits
- No password recovery option available

## File Structure

- `Main.java` - Contains the main program logic and encryption/decryption algorithms
- `Input.java` - Handles file I/O operations and user input

## Navigation

- Use `1` to return to the main menu
- Use `2` to exit the program
- Follow on-screen prompts for file operations

## Warning

⚠️ **IMPORTANT**: Always keep a backup of your original files before encryption. If you lose the password, there is no way to recover the encrypted data.

## License

This project is available for free use and modification.