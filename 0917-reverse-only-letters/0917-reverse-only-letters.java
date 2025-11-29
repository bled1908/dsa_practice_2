class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray(); // 1. Convert the string to an array of characters so we can change them.
        int left = 0; // 2. "left" pointer starts at the beginning of the array.
        int right = chars.length - 1; // 3. "right" pointer starts at the end of the array.

        while (left < right) { // 4. Keep going as long as the left pointer is before the right pointer.

            // 5. Move the "left" pointer until we find a LETTER
            while (left < right && !Character.isLetter(chars[left])) {
                left++; // Keep moving to the right
            }

            // 6. Move the "right" pointer until we find a LETTER
            while (left < right && !Character.isLetter(chars[right])) {
                right--; // Keep moving to the left
            }

            // 7. If we found two letters (left and right are still in the correct order), swap them.
            if (left < right) {
                char temp = chars[left]; // Store the left character in a temporary variable.
                chars[left] = chars[right]; // Put the right character in the left position.
                chars[right] = temp; // Put the original left character in the right position.
                left++; // Move left to the right
                right--; // Move right to the left
            }
        }

        return new String(chars); // 8. Convert the modified character array back into a string.
    }
}