class Solution {
    class Pair {
        int mutu;
        String gene;

        Pair(String gene, int mutu) {
            this.gene = gene;
            this.mutu = mutu;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String>set = new HashSet<>(Arrays.asList(bank));
        Queue<Pair>q = new LinkedList<>();
        if(!set.contains(endGene)){
            return -1;
        }
        q.add(new Pair(startGene,0));
         char []ch = new char[]{'A','C','G','T'};
        while(!q.isEmpty()){
            Pair p = q.remove();
            String gene = p.gene;
            int mutu = p.mutu;
            if(endGene.equals(gene)){
                return mutu;
            }
            StringBuilder sb = new StringBuilder(gene);
           
            for(int i = 0;i<gene.length();i++){
                char temp = sb.charAt(i);
                for(char c:ch){
                    if(c!=temp){
                        sb.replace(i,i+1,c+"");
                        if(set.contains(sb.toString())){
                            q.add(new Pair(sb.toString(),mutu+1));
                            set.remove(sb.toString());
                        }
                    }
                }
                sb.replace(i,i+1,temp+"");
            }
        }
        return -1;
    }
}