public class AllCodons {
    public static void main(String[] args) {
        FindAllCodons a = new FindAllCodons();
        a.testFindGene();
    }
}

class FindAllCodons{
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

public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
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

//



    public void testFindGene(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        String gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGCGTGAAATTATAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "AATGC";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "ATAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "ATAATGGGTAGATAAGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);

        dna = "ATAATGTGATAGTTAATGGT";
        System.out.println("DNA strand is "+dna);
        gene = findGene(dna);
        System.out.println("Gene is "+ gene);
    }


    }