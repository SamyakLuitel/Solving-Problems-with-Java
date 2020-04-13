public class findGeneSimpleAndTest {



    public static void main(String[] args) {
            Genefinder a = new Genefinder();
            a.testFindGeneSimple();
    }

}

class Genefinder{
    public String findGeneSimple (String dna){
        //start codon is "ATG
        //stop codon is "TAA"

        String result ="";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){// no ATG
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex +3);

        if (stopIndex == -1){ //no TAA
            return "";
        }
        result = dna.substring(startIndex, stopIndex+3);


        return  result;
    }

    public void testFindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

         dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

         dna = "AATGCGTGAAATTATAATATGGT";
        System.out.println("DNA strand is "+dna);
         gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGC";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);

        dna = "ATAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is "+ gene);
    }
}
