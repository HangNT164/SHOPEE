package com.util;

public class ValidateData {
   //  private static final Pattern REGEX_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");
//    ^ # start-of-string
//            (?=.*[0-9]) # a digit must occur at least once
//            (?=.*[a-z]) # a lower case letter must occur at least once
//            (?=.*[A-Z]) # an upper case letter must occur at least once
//            (?=.*[@#$%^&+=]) # a special character must occur at least once replace with your special characters
//            (?=\\S+$) # no whitespace allowed in the entire string
//            .{8,} # anything, at least six places though
//    $ # end-of-string

    public static boolean isEmpty(String... strings) {
        for (String s : strings) {
            if (s.isEmpty()) {
                return true;
            }
        }
        return false;
    }

//    public static boolean isValidatePassword(EditText password) {
//        if (REGEX_PASSWORD.matcher(password.getText().toString()).matches() == true) {
//            return true;
//        } else {
//            password.setError("Password too weak");
//            return false;
//        }
//    }
}
