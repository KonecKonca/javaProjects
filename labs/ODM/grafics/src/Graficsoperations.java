public class Graficsoperations {
    static Grafic grafic1 = new Grafic();
    static Grafic grafic2 = new Grafic();

    private static Grafic egalsKorteji = new Grafic();
    private static Grafic resultGrafic = new Grafic();
    private static Grafic unicOfGragic1 = new Grafic();
    private static Grafic unicOfGrafic2 = new Grafic();

    static String proection(int nomberOfGrafic, int nomberOfProection){
        String result = "{";
        if(nomberOfGrafic == 1){
            if(nomberOfProection == 1){
                for(String str : grafic1.firstElements){
                    result += (str + " ");
                }
            }
            else {
                for(String str : grafic1.secondElements){
                    result += (str + " ");
                }
            }
        }
        else {
            if(nomberOfProection == 1){
                for(String str : grafic2.firstElements){
                    result += (str + " ");
                }
            }
            else {
                for(String str : grafic2.secondElements){
                    result += (str + " ");
                }
            }
        }
        result += "}";
        return result;
    }
    static String inversion(int nomberOfGrafic){
        String result = "{";
        if(nomberOfGrafic == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                result += ("<" + grafic1.secondElements.get(i) + " " + grafic1.firstElements.get(i) + "> ");
            }
        }
        else {
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                result += ("<" + grafic2.secondElements.get(i) + " " + grafic2.firstElements.get(i) + "> ");
            }
        }
        result += "}";
        return result;
    }
    static String crossing(){
        String result = "{";
        resultGrafic = new Grafic();
        searchEgualsKortejei();
        for(int i = 0; i < egalsKorteji.firstElements.size(); i++){
            result += ("<" + egalsKorteji.firstElements.get(i) + " " + egalsKorteji.secondElements.get(i) + "> ");
        }
        result += "}";
        return result;
    }
    static String difference(int index){
        String result = "{";
        if(index == 1){
            unicOfGragic1 = new Grafic();
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                boolean isUnic = true;
                for (int j = 0; j < grafic2.firstElements.size(); j++){
                    if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                            grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                        isUnic = false;
                    }
                }
                if(isUnic){
                    unicOfGragic1.firstElements.add(grafic1.firstElements.get(i));
                    unicOfGragic1.secondElements.add(grafic1.secondElements.get(i));
                    result += ("<" + grafic1.firstElements.get(i) + " " + grafic1.secondElements.get(i) + "> ");
                }
            }
        }
        else if(index == 2){
            unicOfGrafic2 = new Grafic();
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                boolean isUnic = true;
                for (int j = 0; j < grafic1.firstElements.size(); j++){
                    if((grafic2.firstElements.get(i) == grafic1.firstElements.get(j) &&
                            grafic2.secondElements.get(i) == grafic1.secondElements.get(j))){
                        isUnic = false;
                    }
                }
                if(isUnic){
                    unicOfGrafic2.firstElements.add(grafic2.firstElements.get(i));
                    unicOfGrafic2.secondElements.add(grafic2.secondElements.get(i));
                    result += ("<" + grafic2.firstElements.get(i) + " " + grafic2.secondElements.get(i) + "> ");
                }
            }
        }
        result += "}";
        return result;
    }
    static String join(){
        String result = "{";
        difference(1);
        difference(2);
        for(int i = 0 ; i < unicOfGragic1.firstElements.size(); i++){
            result += ("<" + unicOfGragic1.firstElements.get(i) + " " + unicOfGragic1.secondElements.get(i) + "> ");
        }
        for(int i = 0 ; i < unicOfGrafic2.firstElements.size(); i++){
            result += ("<" + unicOfGrafic2.firstElements.get(i) + " " + unicOfGrafic2.secondElements.get(i) + "> ");
        }
        searchEgualsKortejei();
        for(int i = 0; i < egalsKorteji.firstElements.size(); i++){
            result += ("<" + egalsKorteji.firstElements.get(i) + " " + egalsKorteji.secondElements.get(i) + "> ");
        }
        result += "}";
        return result;
    }
    static String simmetricDifference(){
        difference(1);
        difference(2);
        String result = "{";
        for(int i = 0 ; i < unicOfGragic1.firstElements.size(); i++){
            result += ("<" + unicOfGragic1.firstElements.get(i) + " " + unicOfGragic1.secondElements.get(i) + "> ");
        }
        for(int i = 0 ; i < unicOfGrafic2.firstElements.size(); i++){
            result += ("<" + unicOfGrafic2.firstElements.get(i) + " " + unicOfGrafic2.secondElements.get(i) + "> ");
        }
        searchEgualsKortejei();
        result += "}";
        return result;
    }
    static String composition(int index){
        String result = "{";
        if(index == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                for(int j = 0; j < grafic2.firstElements.size(); j++){
                    if(grafic1.secondElements.get(i) == grafic2.firstElements.get(j)){
                        result += ("<" + grafic1.firstElements.get(i) + " " + grafic2.secondElements.get(j) + "> ");
                    }
                }
            }
        }
        else if(index == 2){
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                for(int j = 0; j < grafic1.firstElements.size(); j++){
                    if(grafic2.secondElements.get(i) == grafic1.firstElements.get(j)){
                        result += ("<" + grafic2.firstElements.get(i) + " " + grafic1.secondElements.get(j) + "> ");
                    }
                }
            }
        }
        result += "}";
        return result;
    }

    static void searchEgualsKortejei(){
        egalsKorteji = new Grafic();
        for(int i = 0; i < grafic1.firstElements.size(); i++){
            for(int j = 0; j < grafic2.firstElements.size(); j++){
                if((grafic1.firstElements.get(i) == grafic2.firstElements.get(j) &&
                        grafic1.secondElements.get(i) == grafic2.secondElements.get(j))){
                    egalsKorteji.firstElements.add(grafic1.firstElements.get(i));
                    egalsKorteji.secondElements.add(grafic1.secondElements.get(i));
                }
            }
        }
    }
    static String printGrafic(int index){
        String result = "{";
        if(index == 1){
            for(int i = 0; i < grafic1.firstElements.size(); i++){
                result += ("<" + grafic1.firstElements.get(i) + " " + grafic1.secondElements.get(i) + "> ");
            }
        }
        if(index == 2){
            for(int i = 0; i < grafic2.firstElements.size(); i++){
                result += ("<" + grafic2.firstElements.get(i) + " " + grafic2.secondElements.get(i) + "> ");
            }
        }
        if(index == 3){
            for(int i = 0; i < resultGrafic.firstElements.size(); i++){
                result += ("<" + resultGrafic.firstElements.get(i) + " " + resultGrafic.secondElements.get(i) + "> ");
            }
        }
        result += "}";
        return result;
    }
}
