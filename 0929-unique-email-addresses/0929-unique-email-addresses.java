import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder normalized = new StringBuilder();

            // Split the email into local name and domain
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            // Process the local name
            for (int i = 0; i < local.length(); i++) {
                char c = local.charAt(i);
                if (c == '+') {
                    break; // Stop processing after '+'
                }
                if (c != '.') {
                    normalized.append(c); // Ignore dots
                }
            }

            // Append the domain to the normalized local name
            normalized.append(domain);

            // Add the normalized email to the set
            uniqueEmails.add(normalized.toString());
        }

        // The size of the set represents the number of unique emails
        return uniqueEmails.size();
    }
}
