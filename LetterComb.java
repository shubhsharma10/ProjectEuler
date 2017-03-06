// Leetcode problem number: 17 Letter combination of a phone number


public class LetterComb
{
    public List<String> letterCombinations(String digits) 
    {
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        LinkedList<String> queue = new LinkedList<String>();
        if(len == 0)
            return queue;
        queue.addLast("");
        int i=0;
        for(i=0;i<len;i++)
        {
            int x = Character.getNumericValue(digits.charAt(i));
            while(queue.peek().length() == i)
            {
                String st = queue.removeFirst();
                for(char c : mapping[x].toCharArray())
                    queue.add(st+c);
            }
        }
        return queue;
    }
}