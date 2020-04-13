public class findDNA {
    public static void main(String[] args) {
        Genefinder a = new Genefinder();
        a.testFindGeneSimple();
        System.out.println();
    }
}

class DNAfinder{
    public String findGeneSimple(String dna){
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){// no ATG
            return "";
        }


        int currIndex = dna.indexOf("TAA",startIndex +3);
        if (currIndex == -1){// no ATG
            return "";
        }

        while (currIndex  != -1){
            if ((currIndex - startIndex) % 3 ==0){
                return dna.substring(startIndex, currIndex);
            }
            else{
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        return "";
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
