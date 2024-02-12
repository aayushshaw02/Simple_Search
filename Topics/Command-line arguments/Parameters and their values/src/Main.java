class Problem {
    public static void main(String[] args) {
        output(args);
    }
    public static void output(String[] input){
        int size= input.length;
        int noOfParameters=size/2,count=0;
        String[][] result=new String[noOfParameters][2];
        for(int i=0;i<noOfParameters;i++){
            for(int j=0;j<2;j++){
                result[i][j]=input[count];
                count++;
            }
            System.out.println(result[i][0]+"="+result[i][1]);
        }
    }
}