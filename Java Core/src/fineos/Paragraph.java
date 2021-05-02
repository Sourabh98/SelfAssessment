package fineos;

public class Paragraph {
    public static String changeFormat(String paragraph) {
        String[] splitParagraph=paragraph.split("-");
        System.out.println(splitParagraph[2]);
        for(String s:splitParagraph)
        {
        	System.out.println(s);
        }
        //System.out.println(splitParagraph[1]);
        String policyNumber=splitParagraph[1];
       System.out.println(paragraph.replaceAll("-", "/"));
        String normalizedPolicyNumber;
        if(policyNumber.contains("-"))
        {
        	normalizedPolicyNumber=policyNumber.substring(1,4)+"/"+policyNumber.substring(8, 12)+"/"+policyNumber.substring(5, 7)+".";
        	System.out.println(normalizedPolicyNumber);
        }
       // throw new UnsupportedOperationException("Waiting to be implemented.");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(changeFormat("Please quote your policy number: 112-39-8552."));
    }
}
