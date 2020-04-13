public class PrintAllTheGene {
    public static void main(String[] args) {
        Print_all_the_found_codon p = new Print_all_the_found_codon();
        p.testFindGene();
    }
}



class Print_all_the_found_codon{
    public int findStopCodon (String dnaStr, int startIndex ,
                              String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon,startIndex +3);

        while (currIndex != -1){
            int diff = currIndex -startIndex;
            if (diff % 3 == 0){
                return currIndex;

            }
            else{
                currIndex = dnaStr.indexOf(stopCodon, currIndex +1);
            }

        }
        return -1;
    }

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int TAA_Index = findStopCodon(dna, startIndex, "TAA");
        int TAG_Index = findStopCodon(dna, startIndex, "TAG");
        int TGA_Index = findStopCodon(dna, startIndex, "TGA");
        // int temp  =Math.min(TAA_Index,TAG_Index);
        //int minIndex =Math.min(temp, TGA_Index);
        //if (minIndex == dna.length()){
        int minIndex = 0;
        if (TAA_Index == -1 || TGA_Index != -1 && TGA_Index < TAA_Index){
            minIndex =TGA_Index;

        }
        else{
            minIndex = TAA_Index;
        }

        if (minIndex == -1 || TAG_Index != -1 && TAG_Index < minIndex){
            minIndex = TGA_Index;
        }

        if (minIndex == -1){
            return "";
        }
        return dna.substring(startIndex,minIndex +3 );
    }

    public void printAllGenes(String dna){
        int startIndex = 0;
        while (true){
            String currentGene =findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }

    }

    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " +dna);
        printAllGenes(dna);
    }

    public void testFindGene(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);


        dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);

        dna = "AATGCGTGAAATTATAATATGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);


        dna = "AATGC";
        System.out.println("DNA strand is "+dna);
        testOn(dna);

        dna = "ATAATATGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);


        dna = "ATAATGGGTAGATAAGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);


        dna = "ATAATGTGATAGTTAATGGT";
        System.out.println("DNA strand is "+dna);
        testOn(dna);

    }


}