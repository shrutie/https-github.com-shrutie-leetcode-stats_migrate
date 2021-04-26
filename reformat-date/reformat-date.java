class Solution {
    public String reformatDate(String date) {
        Map<String, Integer> months = new HashMap<>();
        months.put("Jan",1);
        months.put("Feb",2);
        months.put("Mar",3);
        months.put("Apr",4);
        months.put("May",5);
        months.put("Jun",6);months.put("Jul",7);months.put("Aug",8);months.put("Sep",9);
        months.put("Oct",10);months.put("Nov",11);months.put("Dec",12);
     
        String[] values =  date.split(" ");
        int n= values.length;
        String newFormat ="";
        for(int i=n-1;i>=0;i--){
            if(i==1){
                String currMonth = ""+months.get(values[i]);
                if(currMonth.length()==1){
                     newFormat+="0"+currMonth+"-";
                }
                else{
                     newFormat+=currMonth+"-";
                }
               
            }
            else if(i==0){
                String dateNum = values[i];
               String dateSt = dateNum.substring(0, dateNum.length()-2);
                if(dateSt.length()==1){
                    dateSt= "0"+dateSt;
                }
                newFormat+= dateSt;
                
            }
            else{
                newFormat+= values[i]+"-";
            }
        }
     return newFormat;   
    }
}