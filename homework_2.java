public class homework_2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where");
        String unfiltredString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String filteredString = unfiltredString.replaceAll("[{}\"\s]", "");
        String[] filteredArray = filteredString.split(",");
        for (String slice : filteredArray) {
            String aditedSlice = slice.replaceAll(":", " =#");
            String[] convertSlice = aditedSlice.split("#");
            if (convertSlice[1].equals("null")) {
                continue;
            } else {
                sb.append(" ").append(convertSlice[0]).append(" \"" + convertSlice[1] + "\"").append(" and");
            }

        }
        System.out.print(sb.delete(sb.length() - 4, sb.length()));
    }
}
