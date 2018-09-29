public enum Nedilia {
    monday(1),
    tuesday(2),
    wensday(3),
    friday(4),
    fortsday(5),
    sartyday(6),
    sanday(7){     // переопределения для воскресенья
        int getDopZnach(){
            return (dopZnach + 100);
        }
    };

    int znach;
    int dopZnach = 7;

    Nedilia(int i){
        znach = i;
    }

    int getZnach(){
        return znach;
    }

    int getDopZnach(){
        return dopZnach;
    }
}
