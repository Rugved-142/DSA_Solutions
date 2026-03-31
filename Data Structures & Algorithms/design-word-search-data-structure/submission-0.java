class WordDictionary {
    private List<String> list;
    public WordDictionary() {
        list = new ArrayList<>();
    }

    public void addWord(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        for(String w : list){
            if(w.length() != word.length())  continue;

            int i = 0;
            while(i < w.length()){
                if(w.charAt(i) == word.charAt(i) || word.charAt(i) == '.'){
                    i++;
                }else{
                    break;
                }
            }
            if(i == w.length()) return true;
        }
        return false;
    }
}
