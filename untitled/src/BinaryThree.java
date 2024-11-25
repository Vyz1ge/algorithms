import java.util.ArrayList;
/*
    @Override
    public String toString() {
        String s = "";
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t" + (root.getValue() != 0 ? root.getValue() : "null") + "\n");
        System.out.println("\t\t\t\t\t\t\t" + (root.getLow() != null ? root.getLow().getValue() : "null") + "\t\t\t\t\t\t\t\t" + (root.getHigh() != null ? root.getHigh().getValue() : "null"));
        System.out.println("\n"
                + "\t\t\t\t\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getValue() != 0 ? root.getLow().getLow().getValue() : "null") + "\t\t\t\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getValue() != 0 ? root.getLow().getHigh().getValue() : "null") + "\t\t\t\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getValue() != 0 ? root.getHigh().getLow().getValue() : "null") + "\t\t\t\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getValue() != 0 ? root.getHigh().getHigh().getValue() : "null"));
        System.out.println("\n"
                + "\t\t\t\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getLow() != null && root.getLow().getLow().getLow().getValue() != 0 ? root.getLow().getLow().getLow().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getHigh() != null && root.getLow().getLow().getHigh().getValue() != 0 ? root.getLow().getLow().getHigh().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getLow() != null && root.getLow().getHigh().getLow().getValue() != 0 ? root.getLow().getHigh().getLow().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getHigh() != null && root.getLow().getHigh().getHigh().getValue() != 0 ? root.getLow().getHigh().getHigh().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getLow() != null && root.getHigh().getLow().getLow().getValue() != 0 ? root.getHigh().getLow().getLow().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getHigh() != null && root.getHigh().getLow().getHigh().getValue() != 0 ? root.getHigh().getLow().getHigh().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getLow() != null && root.getHigh().getHigh().getLow().getValue() != 0 ? root.getHigh().getHigh().getLow().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getHigh() != null && root.getHigh().getHigh().getHigh().getValue() != 0 ? root.getHigh().getHigh().getHigh().getValue() : "null")
        );
        return s;
    }

*/

public class BinaryThree {
    Node root; // ЭТО САМЫЙ ГЛАВНЫЙ КОРЕНЬ ДЕРЕВА КАК HEAD В LINKED LIST

    BinaryThree() { // КОНСТРУКТОР БИНАРНОГО ДЕРЕВА
        root = null;// ПРИСВАИВАНИЕ КОРНЮ НУЛЛ
    }

    void add(int value) {// ФУНКЦИЯ ДОБАВЛЕНИЯ ЭЛЕМЕНТА В БИНАРНОЕ ДЕРЕВО
        if (root == null) { // ЕСЛИ ТАК НАЗЫВАЕМОГО КОРНЯ(ХЕДЕРА) НЕТ ТООО
            root = new Node(value, null); // ПЕРВЫЙ ЭЛЕМЕНТ БУДЕТ РАВНЯТЬСЯ ИМЕННО ЕМУ
            return;// ВЫХОДИМ ПОТОМУ ЧТО ПЕРВАЯ ЭТЕРАЦИЯ
        }
        add(root, value); // ЕСЛИ УЖЕ ВТОРОЙ ЭЛЕМЕНТ ДОБАВЛЯЕМ В ДЕРЕВО, ТО ВЫЗЫВАЕТЬСЯ ДРУГАЯ ФУНКЦИЯ ДОБАВЛЕНИЯ
    }

    void add(Node vershina, int value) {  // УЖЕ ДРУГАЯ ФУНКЦИЯ ДОБАВЛЕНИЯ
        if (vershina == null) {// ЕЩЁ РАЗ ПРОВЕРЯЕМ РОДИЛТЕЛЯ ЕСТЬ ЛИ ОН (МИНИ-ХЕДЕР)
            return; // ВЫХОЖУ ЕСЛИ ВООБЩЕ НЕТ ВЕРШИН
        }
        if (value < vershina.value) { // ЕСЛИ ЗНАЧЕНИЕ МЕНЬШЕ ЧЕМ У РОДИТЕЛЯ
            if (vershina.low == null) { // ТО ПРОВЕРЯЮ ЕСТЬ ЛИ У ЭТОГО РОДИТЕЛЯ ЛЕВАЯ МЕНЬШАЯ ЧАСТЬ
                vershina.low = new Node(value, vershina);// И ПРИСВАИВАЮ ЕМУ УЗЕЛ С ЗНАЧЕНИЕМ И ССЫЛКОЙ НА РОДИТЕЛЯ
                return; // ВЫХОЖУ
            }
            add(vershina.low, value);// ЕСЛИ ЕСТЬ УЖЕ ЛЕВАЯ МЕНЬШАЯ ЧАСТЬ, ТО ПРОИЗВОЖУ РЕКУРСИЮ И ПОДАЮ ЭТО ЖЕ ЗНАЧЕНИЕ СО ССЫЛКОЙ НА РОДИТЕЛЯ ЭТОГО РОДИТЕЛЯ
        } else {// ЕСЛИ ЗНАЧЕНИЕ БОЛЬШЕ ЧЕМ У РОДИТЕЛЯ
            if (vershina.high == null) {// ТО ПРОВЕРЯЮ ЕСТЬ ЛИ У ЭТОГО РОДИТЕЛЯ ПРАВАЯ БОЛЬШАЯ ЧАСТЬ
                vershina.high = new Node(value, vershina);// И ПРИСВАИВАЮ ЕМУ УЗЕЛ С ЗНАЧЕНИЕМ И ССЫЛКОЙ НА РОДИТЕЛЯ
                return;// ВЫХОЖУ
            }
            add(vershina.high, value);// ЕСЛИ ЕСТЬ УЖЕ ПРАВАЯ БОЛЬШАЯ ЧАСТЬ, ТО ПРОИЗВОЖУ РЕКУРСИЮ И ПОДАЮ ЭТО ЖЕ ЗНАЧЕНИЕ СО ССЫЛКОЙ НА РОДИТЕЛЯ ЭТОГО РОДИТЕЛЯ
        }
    }

    Node fromArray(ArrayList<Integer> list, int low, int high) {// ВОЗВРАЩЕНИЕ УЗЛА ЭЛЕМЕНТА КОТОРЫЙ СОДЕРЖИТ ССЫЛКИ НА ЛОУ И ХАЙ И У НЕГО ЕЩЁ ЕСТЬ РОДИТЕЛЬ \/ -> ТУТ У МЕНЯ ПАРАМЕТРЫ ТОГО ЖЕ САМОГО ЛИСТА ЛОУ НОЛЬ НООО ХАЙ ТЕПЕРЬ КАК МИДЛ
        if (low + 1 > high) { //ЕСЛИ ЗНАЧЕНИЕ ПЛЮС ОДИН НИЗА ЭЛЕМЕНТА БОЛЬШЕ ЧЕМ ХАЙ \/ -> СООТВЕСВЕТСТВЕННО ТУТ УСЛОВИЕ СКИП НАВЕРНОЕ ПОТОМУ ЧТО ВТОРАЯ ИТЕРАЦИЯ
            return null; // ТО ВОЗРАЩАЮ НУЛЛ \/ -> ТУТ ТОЖЕ СКИП
        }
        if (low + 1 == high) {// ЕСЛИ ЗНАЧЕНИЕ ПЛЮС ОДИН НИЗА ЭЛЕМЕНТА РАВНО ВЫШИНЕ ЭЛЕМЕНТА  \/ -> ТУТ ТОЖЕ СКИП
            return new Node(list.get(low), null); // ТО СОЗДАЮ ЭЛЕМЕНТ УЗЛА СО ССЫЛКОЙ НА НУЛЛ \/ -> ТУТ ТОЖЕ СКИП НО КАК-ТО ИНТЕРЕСНО
        }
        int middle = (low + high) / 2;// ТУТ ЗАЧЕМ-ТО СЧИТАЮ МИДЛ
        Node t = new Node(list.get(middle), null); // СОЗДАЮ НОВЫЙ УЗЕЛ БЕРУ ЗНАЧЕНИЕ МИДЛ ИЗ ЛИСТА
        t.low = fromArray(list, low, middle); // ТУТ УЖЕ ПРОИЗВОЖУ РЕКУРСИВНУЮ ФУНКЦИЮ ДЛЯ НОУД ПОИСКА ЛОУ *
        t.high = fromArray(list, middle + 1, high); // ТОЖЕ САМОЕ ТЕПЕРЬ ДЕЛАЮ С ХАЕМ ЧТО И С ЛОУ ТОЛЬКО ЛОУ ДАЮ ПОЗИЦИЮ МИДЛ ПЛЮС ОДИН
        if (t.low != null) { // ПРОВЕРЯЕМ ЕСЛИ ЛОУ НЕ РАВЕН НУЛУ
            t.low.parent = t;// ТО У ЛОУ ВЫЗЫВАЮ РОДИТЕЛЯ И ДАЮ ССЫЛКУ НА СОЗДАННЫЙ УЗЕЛ СОЗДАННЫЙ ЗНАЧЕНИЕМ МИДЛ ИЗ ЛИСТА
        }
        if (t.high != null) {// ПРОВЕРЯЮ ЕСЛИ ХАЙ НЕ РАВЕН НУЛУ
            t.high.parent = t;// ТО У ХАЙ ВЫЗЫВАЮ РОДИТЕЛЯ И ДАЮ ССЫЛКУ НА СОЗДАННЫЙ УЗЕЛ СОЗДАННЫЙ ЗНАЧЕНИЕМ МИДЛ ИЗ ЛИСТА
        }
        return t; // НУ И ВОЗВРАЩАЮ УЗЕЛ СО ВСЕМИ ЕГО ПАРАМЕТРАМИ
    }

    BinaryThree fromArray(ArrayList<Integer> list) { // ПРЕВРАЩЕНИЕ ОБЫЧНОГО ОТСОРТИРОВАННОГО ЛИСТА В ДЕРЕВО
        BinaryThree binaryThree = new BinaryThree(); // СОЗДАЮ ЭЛЕМЕНТ БАЙНЕРИ ТРИ КСТАТИ ВО ВРЕМЯ ЕГО СОЗДАНИЯ СОЗДАЁТЬСЯ ПУСТОЙ РУТ, ТО ЕСТЬ КОРЕНЬ
        binaryThree.root = fromArray(list, 0, list.size()); // ТЕПЕРЬ Я ПРИСВАИВАЮ РУТУ ССЫЛКУ НА УЗЕЛ ПЕРВОГО ПЭРЕНТ ??
        return binaryThree;// ЕСТЕВСТВЕННО ВОЗВРАЩАЮ САМО ДЕРЕВО
    }

    @Override
    public String toString() {
        String s = "";
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t" + (root.value != 0 ? root.value : "null") + "\n");
        System.out.println("\t\t\t\t\t\t\t" + (root.low != null ? root.low.value : "null") + "\t\t\t\t\t\t\t\t" + (root.high != null ? root.high.value : "null"));
        System.out.println("\n"
                + "\t\t\t\t\t"
                + (root.low != null && root.low.low != null && root.low.low.value != 0 ? root.low.low.value : "null") + "\t\t\t\t"
                + (root.low != null && root.low.high != null && root.low.high.value != 0 ? root.low.high.value : "null") + "\t\t\t\t"
                + (root.high != null && root.high.low != null && root.high.low.value != 0 ? root.high.low.value : "null") + "\t\t\t\t"
                + (root.high != null && root.high.high != null && root.high.high.value != 0 ? root.high.high.value : "null"));
        System.out.println("\n"
                + "\t\t\t\t"
                + (root.low != null && root.low.low != null && root.low.low.low != null && root.low.low.low.value != 0 ? root.low.low.low.value : "null") + "\t"
                + (root.low != null && root.low.low != null && root.low.low.high != null && root.low.low.high.value != 0 ? root.low.low.high.value : "null") + "\t"
                + (root.low != null && root.low.high != null && root.low.high.low != null && root.low.high.low.value != 0 ? root.low.high.low.value : "null") + "\t"
                + (root.low != null && root.low.high != null && root.low.high.high != null && root.low.high.high.value != 0 ? root.low.high.high.value : "null") + "\t"
                + (root.high != null && root.high.low != null && root.high.low.low != null && root.high.low.low.value != 0 ? root.high.low.low.value : "null") + "\t"
                + (root.high != null && root.high.low != null && root.high.low.high != null && root.high.low.high.value != 0 ? root.high.low.high.value : "null") + "\t"
                + (root.high != null && root.high.high != null && root.high.high.low != null && root.high.high.low.value != 0 ? root.high.high.low.value : "null") + "\t"
                + (root.high != null && root.high.high != null && root.high.high.high != null && root.high.high.high.value != 0 ? root.high.high.high.value : "null")
        );
        return s;
    }

    Node find(Node vershina, int value) {// ВОЗВРАЩАЮ УЗЕЛ В КОТОРОМ НАХОДИТЬСЯ ДАННЫЙ ЭЛЕМЕНТ
        if (vershina == null) { // ЕСЛИ ВЕРШИНА РАВНА НУЛЮ
            return null;// ТО ВОЗВРАЩАЮ НУЛЛ
        }
        if (vershina.value == value) { // ЕСЛИ ЗНАЧЕНИЕ ВЕРШИНЫ СОВПАДАЕТ С ПОИСКОВЫМ ЗНАЧЕНИЕМ
            return vershina;// ТО ВОЗВРАЩАЮ ВЕРШИНУ
        }
        if (vershina.value > value) { // ЕСЛИ ЗНАЧЕНИЕ ВЕРШИНЫ БОЛЬШЕ ЧЕМ ПОИСКОВОЕ ЗНАЧЕНИЕ
            return find(vershina.low, value);// ТО РЕКУРСИВНО СПУСКАЮСЬ ПО ДЕРЕВУ ПОСТОЯННО ВЫЗЫВАЮ ЛОУ У ВЕРШИНЫ
        } else {// ЕСЛИ НАОБОРОТ МЕНЬШЕ
            return find(vershina.high, value);// ТО РЕКУРСИВНО ПОДНИМАЮСЬ ПО ДЕРЕВУ
        }
    }

    Node find(int value) { // НАХЛЖДЕНИЕ ЭЛЕМЕНТА В ДЕРЕВЕ
        return find(root, value);// ВОЗВРАЩАЮ ССЫЛКУ НА НАЙДЕННЫЙ ЭЛЕМЕНТ
    }

    void delete(Node t) {// УДАЛЕНИЕ УЗЛА
        if (t == null) { // ПРОВЕРЯЮ НЕ НУЛЛ ЛИ УЗЕЛ
            return;//ВЫХОЖУ ЕСЛИ НУЛ
        }
        if ((t.low == null) || (t.high == null)) { // ПРОВЕРЯЮ ЕСЛИ ЛОУ УЗЛА КОТОРЫЙ ХОЧУ УДАЛИТЬ РАВНО НУЛУ    ИЛИ    ХАЙ РАВЕН НУЛУ
            Node child = null; // СОЗДАЮ ВЕТВЬ ДЕРЕВА ИЛИ ЖЕ СЫНА
            if (t.low != null) {// ЕСЛИ ЛОУ УЗЛА КОТОРЫЙ Я ХОЧУ УДАЛИТЬ НЕ РАВЕН НУЛУ
                child = t.low;// ТО ПРИСВАИВАЮ СЫНУ ИЛИ ВЕТВИ ЭТО ЛОУ
            } else { // ЕСЛИ ЛОУ ИЗ УЗЛА КОТОРЫЙ Я ХОЧУ УДАЛИТЬ РАВНЯТЬСЯ НУЛУ
                child = t.high; // ТО ПРИСВАИВАЮ СЫНУ ИЛИ ВЕТВИ ЭТОТ ХАЙ
            }
            if (t == root) { // ЕСЛИ ССЫЛКА НА ЭЛЕМЕНТ КОТОРЫЙ Я ХОЧУ УДАЛИТЬ РАВНЯЕТЬСЯ КОРНЮ ДЕРЕВА
                root = child;// ТО ПРИСВАИВАЮ КОРНЮ РЕБЁНКА ЭТОГО ДЕРЕВА
                if (child != null) { // ЕСЛИ РЕБЁНОК ИЛИ ВЕТВЬ НЕ РАВЕН НУЛУ
                    child.parent = null; // ТО РОДИТЕЛЮ РЕБЁНКА ПРИСВАИВАЮ НУЛЛ
                }
            }
            if (t.parent.low == t) { // ЕСЛИ ЛОУ РОДИТЕЛЯ УЗЛА ЭЛЕМЕНТА КОТОРЫЙ ХОЧУ УДАЛИТЬ РАВЕН ТОМУ ЭЛЕМЕНТУ КОТОРЫЙ Я ХОЧУ УДАЛИТЬ
                t.parent.low = child;// ТО ЛОУ РОДИТЕЛЯ УЗЛА ЭЛЕМЕНТА КОТОРЫЙ ХОЧУ УДАЛИТЬ ПРИРАВНИВАЕТЬСЯ ЕГО РЕБЁНОК ИЛИ ВЕТВЬ
                if (child != null) {// ЕСЛИ РЕБЁНОК НЕ РАВЕН НУЛУ
                    child.parent = t.parent;// ТО РОДИТЕЛЮ РЕБЁНКА ПРИСВАИВАЮ РОДИТЕЛЯ ЭЛЕМЕНТА УЗЕЛ КОТОРОГО Я ХОЧУ УДАЛИТЬ
                }
            } else { // ЕСЛИ ЛОУ РОДИТЕЛЯ УЗЛА ЭЛЕМЕНТА КОТОРЫЙ ХОЧУ УДАЛИТЬ НЕ НЕ РАВЕН ТОМУ ЭЛЕМЕНТУ КОТОРЫЙ Я ХОЧУ УДАЛИТЬ
                t.parent.high = child; // ТО ХАЮ РОДИТЕЛЯ УЗЛА ЭЛЕМЕНТА КОТОРЫЙ ХОЧУ УДАЛИТЬ ПРИРАВНИВАЕТЬСЯ ЕГО РЕБЁНОК ИЛИ ВЕТВЬ
                if (child != null) {// ЕСЛМ РЕБЁНОК НЕ РАВЕН НУЛУ
                    child.parent = t.parent; // ТО РОДИТЕЛЮ РЕБЁНКА ПРИСВАИВАЮ РОДИТЕЛЯ ЭЛЕМЕНТА УЗЕЛ КОТОРОГО Я ХОЧУ УДАЛИТЬ
                }
            }
        } else { // ЕСЛИ ЛОУ И ХАЙ УЗЛА КОТОРЫЙ Я ХОЧУ УДАЛИТЬ НЕ РАВНЫ НУЛУ
            Node nxt = t.high; // ТО СОЗДАЮ УЗЕЛ КОТОРЫЙ ПРИСВАИВАЕТЬСЯ ХАЮ ЭЛЕМЕНТА КОТОРЫЙ Я ХОЧУ УДАЛИТЬ
            while (nxt.low != null) { // ЕСЛИ ЛОУ ХАЯ ЭЛЕМЕНТА УЗЛА КОТРОРЫЙ Я ХОЧУ УДАЛИТЬ НЕ РАВНЯЕТЬСЯ НУЛУ
                nxt = nxt.low; // ТО ХАЙ УЗЛА КОТОРЫЙ Я ХОЧУ УДАЛИТЬ ПРИСВАИВАЕТЬСЯ ЛОУ ЭТОГО УЗЛА
            }
            t.value = nxt.value; // ЗНАЧЕНИЮ УЗЛА КОТОРОГО Я ХОЧУ УДАЛИТЬ ПРИСВАИВАЕТЬСЯ ЗНАЧЕНИЕ ЛИБО ХАЮ ЛИБО ЛОУ УЗЛА ЭТОГО ЭЛЕМЕНТА В ЗАВИСИМОСТИ ОТ СИТУАЦИИ
            delete(nxt); // ВЫПОЛНЯЮ РЕКУРСИЮ С НОВЫМ ЗНАЧЕНИЕМ ЭЛЕМЕНТА
        }
    }

    void delete(int value) {  // УДАЛЯЮ ЭЛЕМЕНТ СО ЗНАЧЕНИЕМ ВЭЛЬЮ
        if (root == null) {// ЕСЛИ ДЕРЕВА НЕТ
            return;// ТО ВЫХОЖУ
        }
        Node t = find(value);// НАХОЖУ ЭЛЕМЕНТ В ДЕРЕВЕ КОТОРЫЙ ХОЧУ УДАЛИТЬ
        if (t == null) { // ЕСЛИ ЭЛЕМЕНТ НЕ НАЙДЕН
            return;// ТО ВЫХОЖУ
        }
        delete(t); // УДАЛЯЮ
    }

    Node next(Node vershina) { // МЕТОД ВОЗВРАЩАЮЩИЙ СЛЕДУЮЩИЙ ЭЛЕМЕНТ
        if (vershina == null) {// ЕСЛИ ВЕРШИНА РАВНА НУЛУ
            return null;// ТО ВОЗВРАЩАЮ НУЛЛ
        }
        if (vershina.high != null) {// ЕСЛИ БОЛЬШАЯ ЧАСТЬ ВЕРШИНЫ НЕ РАВНА НУЛУ
            Node nxt = vershina.high;// ТО СОЗДАЮ УЗЕЛ КОТОРОМУ ПРИСВАИВАЮ ПРАВЫЙ БОЛЬШИЙ УЗЕЛ
            while (nxt.low != null) {// УХОДИМ МАКСИМАЛЬНО ВЛЕВО ВНИЗ
                nxt = nxt.low;// ВЛЕВО ВНИЗ
            }
            return nxt; // ВОЗВРАЩАЮ ЭТОТ СЛЕДУЮЩИЙ ЭЛЕМЕНТ
        }
        Node nxt = vershina;// СОЗДАЮ УЗЕЛ КОТОРОМУ ПРИСВАИВАЮ ВЕРШИНУ
        while ((nxt.parent != null) && (nxt.parent.high == nxt)) {// ПРОВЕРЯЮ РОДИТЕЛЬ НЕ РАВЕН НУЛУ И ЕСЛИ ВЕРШИНА ИМЕЕТ ПРАВУЮ БОЛЬШУЮ ЧАСТЬ
            nxt = nxt.parent;// ТО ПОДНИМАЮСЬ
        }
        return nxt.parent; // ВОЗВРАЩАЮ РОДИТЕЛЯ
    }

    void print(Node vershina) { // ПЕЧАТЬ УЗЛА
        if (vershina == null) {// ЕСЛИ ВЕРШИНА НУЛЛ
            return;// УХОЖУ
        }
        print(vershina.low);//РЕКУРСИЯ ЛЕВОЙ ЧАСТИ ВЕРШИНЫ
        System.out.println(vershina.value);// ПЕЧАТЬ ЗНАЧЕНИЯ
        print(vershina.high);// РЕКУРСИЯ ПРАВОЙ ЧАСТИ ВЕРИШИНЫ
    }

    Node getroot() {// ГЕТТЕР
        return root;
    }

    void print() {// ПЕЧАТЬ
        print(root);
    }

    Node next(int value){
        return next(find(value));
    }

    boolean chek(Node vershina, Integer low, Integer high){ // ПРОВЕРКА ЯВЛЯЕТЬСЯ ЛИ ЭЛЕМЕНТ BST ИЛИ НЕТ
        if (vershina == null){// ЕСЛИ ВЕРШИНА НУЛЛ
            return true;//ПРАВДА
        }
        if((low != null)&&(vershina.value < low)){ // ЕСЛИ ЛОУ НЕ РАВНЯЕТЬСЯ НУЛУ И ЗНАЧЕНИЕ МЕНЬШЕ МИНИМАЛЬНОГО
            return false;//НЕПРАВДА
        }
        if ((high != null)&&(vershina.value > high)){ // ЕСЛИ ЛОУ НЕ РАВНЯЕТЬСЯ НУЛУ И ЗНАЧЕНИЕ БОЛЬШЕ МИНИМАЛЬНОГО
            return false;// НЕПРАВВДА
        }
        return chek(vershina.low,low,vershina.value) && chek(vershina.high,vershina.value,high);// РЕКУРСИЯ ПРОВЕРКА НИЖНИХ ВЕТОК И ВЕРХНИХ ВЕТОК
    }
    boolean chek(){
        return chek(root,null,null); // ПРОВЕРКА ЯВЛЯЕТЬСЯ ЛИ ЭЛЕМЕНТ BST ИЛИ НЕТ
    }
}

class Node {
    int value; // НЕКОТОРОЕ ЗНАЧЕНИЕ
    Node low; // ЛЕВАЯ ЧАСТЬ ДЕРЕВА МНЕ ЕЁ БОЛЕЕ КОМФОРТНО НАЗЫВАТЬ ПРОСТО НАИМЕНЬШИМ ПОТОМУ ЧТО ТАК И ЕСТЬ
    Node high; // ПРАВАЯ ЧАСТЬ ДЕРЕВА ТО ЕСТЬ БОЛЬШАЯ
    Node parent; // РОДИТЕЛЬ, ТО ЕСТЬ КАК МАЛЕНЬКАЯ ВЕРШИНА

    Node(int value, Node parent) { // ОБЫЧНЫЙ КОНСТРУКТОР ВМЕСТЕ С НЕКОТОРЫМ ЗНАЧЕНИЕМ И УЗЛОМ ДЛЯ ЕГО СВЯЗИ САМ УЗЕЛ И ЕСТЬ ВЕРШИНА
        this.value = value; // ПРИСВАЕВАЕМ
        this.parent = parent;// ПРИСВАЕВАЕМ
        this.low = null;// ПРИСВАЕВАЕМ
        this.high = null;// ПРИСВАЕВАЕМ
    }
}

