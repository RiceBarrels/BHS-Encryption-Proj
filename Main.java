class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){
    boolean isDone = false;
    String Error = "";
    String lastOutput = "";
    while (!isDone) {
      // menu
      print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
      if (lastOutput.length() > 0){
        print("================================================");
        print("> " + lastOutput);
      }

      print("================================================");
      print("1. Encrypt");
      print("2. Decrypt");
      print("3. Exit");
      print("================================================");
      if (Error.length() > 0) 
        print("\nERROR: " + Error + "\n");
      
      print("Please enter your choice (1-3):");

      String choice = Input.readString();
      if (choice.equals("1")) {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("type [1] to go Back Menu        type [2] to go Exit");
        print("===================================================");
        print("What is the file name you want to encrypt in the \nsame folder as this program?");
        String fileName = Input.readString();
        if(fileName.equals("1")) continue;
        else if(fileName.equals("2")) break;
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("type [1] to go Back Menu        type [2] to go Exit");
        print("===================================================");
        print("What is the file name you want to encrypt in the \nsame folder as this program?");
        print("===================================================");
        print("> " + fileName);
        print("===================================================");
        print("\nWhat is the name of the file you want to save the \nencrypted file as? (with any extension)");
        String saveFileName = Input.readString();
        if(saveFileName.equals("1")) continue;
        else if(saveFileName.equals("2")) break;

        String encrypted = encryption(Input.readFile(fileName));
        Input.writeFile(saveFileName, encrypted);
        Error = "";
        lastOutput = saveFileName + " is created";

      } else if (choice.equals("2")) {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("type [1] to go Back Menu        type [2] to go Exit");
        print("===================================================");
        print("What is the file name you want to decrypt in the \nsame folder as this program?");
        String fileName = Input.readString();
        if(fileName.equals("1")) continue;
        else if(fileName.equals("2")) break;

        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("type [1] to go Back Menu        type [2] to go Exit");
        print("===================================================");
        print("What is the file name you want to decrypt in the \nsame folder as this program?");
        print("===================================================");
        print("> " + fileName);
        print("===================================================");
        print("\nWhat is the name of the file you want to save the\n decrypted file as? (with any extension)");
        String saveFileName = Input.readString();
        if(saveFileName.equals("1")) continue;
        else if(saveFileName.equals("2")) {
          break;
        }

        String decoded = decode(Input.readFile(fileName));
        Input.writeFile(saveFileName, decoded);
        Error = "";
        lastOutput = saveFileName + " is created";
      } else if (choice.equals("3")) {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBye Bye~");
        isDone = true;
      } else {
        Error = "Invalid choice. Please enter 1, 2, or 3.";
      }
    }
  }
  
  String encryption(String txt){

    //step 1: Request a 4 digit password from the user and store it in a int
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nSet a 4 digit Password (If lost no why to decrypt):");
    String password = Input.readString();
    while (password.length() != 4 || !password.matches("[0-9]+")) {
      if (password.length() != 4) {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nYour password must be 4 digits long\nPlease try again:");
      } else {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nYour password must be a number\nPlease try again:");
      }
      password = Input.readString();
    }
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    print("Password set to " + password);
    print("\n");
    print("Encrypting......");
    print("\n\n\n\n");
    //step 2: receive the first num store it in “skipNum” + 2, and use for loop to skip numbers.
    int skipNum = Integer.parseInt(password.substring(0, 1)) + 2;
    String encrypted = skipEvery(txt, skipNum, "+");
    
    // step 3:
    // turn each char into ascii (from 000 to 255), 
    encrypted = asciiWithZeros(encrypted);
    
    // step 4:
    // flip the string using the flipNum(2nd number of password)
    // for ex: if we get a 3 on flipNum it will turn into 043 
    // then put it in a string 
    // The string would look like this “045 234 190”
    encrypted = flip(encrypted);
    // step 5:
    encrypted = timesNum(encrypted, Integer.parseInt(password.substring(2, 4)));
    
    final String[] allNums = {"1","2","3","4","5","6","7","8","9","0"}; 

    // step 6: generatenumbers
    final String[] randomNumbers = generateNumbers();
    // ex:{"3","2","1","4","6","8","5","9","7","0"}

    // step 7: replace numbers to random nums
    encrypted = replaceArrays(encrypted, allNums, randomNumbers);
    
    // step 8: trun numbers to binary
    final String[] binary = {"0001","0010","0011","0100","0101","0110","0111","1000","1001","0000"};
    encrypted = replaceArrays(encrypted, allNums, binary);
    // step 9: if 1111 to 41
    encrypted = zipper(encrypted);
    // step 10: add the random numbers to the start of the string using
    encrypted = randomNumbers[0] + randomNumbers[1] + randomNumbers[2] + randomNumbers[3] + randomNumbers[4] + randomNumbers[5] + randomNumbers[6] + randomNumbers[7] + randomNumbers[8] + randomNumbers[9] + " " + encrypted;

    return encrypted;
  }
  

  // flip string
  String flip(String txt) {
    String bld = "";
    String[] numbers = txt.split(" ");
    for(int i=0; i<numbers.length; i++){
      for (int x = 0; x < numbers[i].length(); x++){
        bld += numbers[i].substring(numbers[i].length() - x - 1, numbers[i].length() - x);
      }
      bld += " ";
    }
    return bld;
  }

  // timesNum string
  String timesNum(String txt, int times) {
    String bld = "";
    String[] numbers = txt.split(" ");
    for(int i=0; i<numbers.length; i++){
      bld += times * Integer.parseInt(numbers[i]) + " ";
    }
    return bld;
  }

  // devideNum string
  String devideNum(String txt, int devide) {
    String bld = "";
    String[] numbers = txt.split(" ");
    for(int i=0; i<numbers.length; i++){
      bld += Integer.parseInt(numbers[i]) / devide + " ";
    }
    return bld;
  }
  
  int indexOf(char ch, char[] arry){
    for(int x=0; x<=arry.length-1; x++){
      if(arry[x]==ch){
        return x;
      }
    }
    return -1;
  }
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

  String skipEvery(String txt, int skipNum, String plusOrMinus){
    String bld = "";
    if(plusOrMinus.equals("+")){
        for(int i=0; i<skipNum; i+=1){
            for(int j=i; j<txt.length(); j+=skipNum){
                bld = bld + txt.charAt(j);
            }
        }
    } else {
        char[] result = new char[txt.length()];
        int currentPos = 0;
        
        for(int i=0; i<skipNum; i+=1){
            for(int j=i; j<txt.length(); j+=skipNum){
                result[j] = txt.charAt(currentPos);
                currentPos++;
            }
        }
        
        bld = new String(result);
    }
    return bld;
  }

  String asciiWithZeros(String txt){
    String bld = "";
    for(int i=0; i<txt.length(); i++){
      int withoutZero = (int)txt.charAt(i);
      if(withoutZero < 10){
        bld = bld + "00" + withoutZero + " ";
      } else if(withoutZero < 100){
        bld = bld + "0" + withoutZero + " ";
      } else {
        bld = bld + withoutZero + " ";
      }
    }
    return bld;
  }

  String turnAsciiToString(String txt){
    String bld = "";
    String[] numbers = txt.split(" ");
    for(int i=0; i<numbers.length; i++){
      bld += (char)Integer.parseInt(numbers[i]);
    }
    return bld;
  }

  // ex: "25 34 501 1" -> "025 034 501 001"
  String turnTo3Digits(String txt) {
    String bld = "";
    String[] numbers = txt.split(" ");
    for(int i = 0; i < numbers.length; i++) {
        if(numbers[i].length() > 0) {  // Check if the number is not empty
            int num = Integer.parseInt(numbers[i]);
            if(num < 10) {
                bld += "00" + num + " ";
            } else if(num < 100) {
                bld += "0" + num + " ";
            } else {
                bld += num + " ";
            }
        } else {
            bld += " ";  // Preserve empty spaces
        }
    }
    return bld;
  }

  String[] generateNumbers(){
    int[] numbers = {0,1,2,3,4,5,6,7,8,9};
    String generateNumbers[] = new String[10];
    for(int i = 0; i<10; i++){
      int randNum = randInt(0, numbers.length);
      generateNumbers[i] = numbers[randNum]+"";
      numbers = removeIntArray(numbers, randNum);
    }
    return generateNumbers;
  }

  void printStringArray(String[] array){
    String bld = "[";
    for(int i = 0; i<array.length;i++){
      if (array.length == i+1)
        bld += array[i];
      else
        bld += array[i] + ",";
    }
    print(bld+"]");
  }

  String replaceArrays(String txt, String[] replaceWhat, String[] toWhat) {
    String bld = "";
    for(int i = 0; i<txt.length(); i++){
      String characterNow = txt.substring(i, i+1);
      for(int x = 0; x<replaceWhat.length; x++){
        if(characterNow.equals(" ")){
          bld += " ";
          break;
        } else if(characterNow.equals(replaceWhat[x])){
          bld += toWhat[x];
          break;
        }
      }
    }
    return bld;
  }

  String zipper(String txt) {
    String bld = "";
    String together = "";
    for (int i = 0; i<txt.length(); i++) {
        String charNow = txt.substring(i,i+1);
        if (charNow.equals(" ") && together.length() == 0) {
            bld += " ";
        } else if (charNow.equals(" ") && together.length() != 0) {
            // Keep single 1s and 0s as it is
            if (together.length() == 1 && (together.equals("1") || together.equals("0"))) {
                bld += together + " ";
            } else {
                bld += together.length() + together.substring(0, 1) + " ";
            }
            together = "";
        } else if (together.length() == 0 || together.substring(0,1).equals(charNow)) {
            together += charNow;
        } else if (!together.substring(0,1).equals(charNow)) {
            // Keep single 1s and 0s as it is
            if (together.length() == 1 && (together.equals("1") || together.equals("0"))) {
                bld += together;
            } else {
                bld += together.length() + together.substring(0, 1);
            }
            together = charNow;
        } else {
            print("Error: unexpected decision! on zipper");
        }
    }
    if (together.length() > 0) {
        // Handle the last group
        if (together.length() == 1 && (together.equals("1") || together.equals("0"))) {
            bld += together;
        } else {
            bld += together.length() + together.substring(0, 1);
        }
    }
    return bld;
  }

  String unzip(String txt) {
    String bld = "";
    for (int i = 0; i < txt.length(); i++) {
        String charNow = txt.substring(i, i+1);
        if (charNow.equals(" ")) {
            bld += " ";
            continue;
        }
        // If it's a single 1 or 0, keep it as is
        if (charNow.equals("1") || charNow.equals("0")) {
            bld += charNow;
        } else if (Character.isDigit(charNow.charAt(0))) {
            int count = Integer.parseInt(charNow);
            String letter = txt.substring(i+1, i+2);
            for (int j = 0; j < count; j++) {
                bld += letter;
            }
            i++; // Skip the letter character
        }
    }
    return bld;
  }


  int[] removeIntArray(int[] array, int index){
    int newArray[] = new int[array.length - 1];
    for(int i = 0; i<array.length; i++){
      if (i < index){
        newArray[i] = array[i];
      } else if (i > index){
        newArray[i-1] = array[i];
      }
    }
    return newArray;
  }

  String[] getStringArrayFromTxt(String txt, int arrayLength){
    String newArray[] = new String[arrayLength];
    for(int i = 0; i < arrayLength; i++){
      newArray[i] = txt.substring(i,i+1);
    }
    return newArray;
  }

  String unBi(String txt) {
    final String[] binary = {"0001","0010","0011","0100","0101","0110","0111","1000","1001","0000"};
    final String[] allNums = {"1","2","3","4","5","6","7","8","9","0"}; 
    String bld = "";
    String fourCode = "";
    
    for(int i = 0; i < txt.length(); i++) {
        String charNow = txt.substring(i, i+1);
        
        if(charNow.equals(" ")) {
            // If we have a complete four-digit code when we hit a space
            if(fourCode.length() == 4) {
                for(int x = 0; x < binary.length; x++) {
                    if(binary[x].equals(fourCode)) {
                        bld += allNums[x];
                        break;
                    }
                }
            }
            bld += " ";
            fourCode = "";
        } else {
            fourCode += charNow;
            // Check if we have a complete four-digit code
            if(fourCode.length() == 4) {
                for(int x = 0; x < binary.length; x++) {
                    if(binary[x].equals(fourCode)) {
                        bld += allNums[x];
                        fourCode = "";
                        break;
                    }
                }
            }
        }
    }
    
    // Handle any remaining code at the end
    if(fourCode.length() == 4) {
        for(int x = 0; x < binary.length; x++) {
            if(binary[x].equals(fourCode)) {
                bld += allNums[x];
                break;
            }
        }
    }
    
    return bld;
  }

  String decode(String encrypted) {
    String decoded = encrypted;
    final String[] allNums = {"1","2","3","4","5","6","7","8","9","0"}; 
    String[] randomNumbers = getStringArrayFromTxt(decoded, 10);
    
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    print("Please enter the 4 digit Password (If lost no way to decrypt):");
    String password = Input.readString();
    while (password.length() != 4 || !password.matches("[0-9]+")) {
      if (password.length() != 4) {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("Your password must be 4 digits long:");
      } else {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        print("Your password must be a number:");
      }
      password = Input.readString();
    }
    print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    print("Password set to " + password);
    print("\n");
    print("Decrypting......");
    print("\n\n\n\n");
    // 9
    decoded = decoded.substring(11);
    // 8
    decoded = unzip(decoded);
    // 7
    decoded = unBi(decoded);
    // 6
    decoded = replaceArrays(decoded, randomNumbers, allNums);
    // 5
    decoded = devideNum(decoded, Integer.parseInt(password.substring(2, 4)));
    // 4
    decoded = turnTo3Digits(decoded);
    // 3
    decoded = flip(decoded);
    // 2
    decoded = turnAsciiToString(decoded);
    // 1
    decoded = skipEvery(decoded, Integer.parseInt(password.substring(0, 1)) + 2, "-");
    return decoded;
  }
}
