import java.util.Scanner; // �פJ�W�٬� Scanner ���Ҳ� (�ϥΨӨ��o�ϥΪ̿�J�����)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

class Main // �M�צW��_ExUser (�O�o�n���ɮצW�٬ۦP)
{

    //static Person[] emp;         // ���u��ƪ�����}�C
    static int k=0;                // �����x�s����
    static Person [] emp = new Person[300];
    static boolean work =true , finish_time = true, start_time = true , percent = true,state = true, number = true,classify = true, content = true, salary = true ,day = true;
    static int s = 1;
    public static void main(String[] args)throws IOException {
        user();
        Scanner scc = new Scanner(System.in);
        int ss = scc.nextInt();
        switch (ss) {
            case 1:
                String InUserID, InUserPW; // �ϥΪ̱b���P�K�X��J
                String UserID = "cis", UserPW = "1234"; // �w�]�ϥΪ̱b���P�K�X �b���� cis �K�X�� 1234
                Scanner Inp = new Scanner(System.in);    // �Q�� Inp �o���ܼƦW��(�i�H�ۥѧ��) �Ө��o�ϥΪ̿�J�����

                System.out.print("�п�J�ϥΪ̱b���G ");
                InUserID = Inp.nextLine();
                System.out.print("�п�J�ϥΪ̱K�X�G ");
                InUserPW = Inp.nextLine();
                if (InUserID.equals(UserID) && InUserPW.equals(UserPW)) // �P�_�b���K�X�O�_�ҥ��T
                {
                    System.out.println("�n�J���\!");

                    Scanner keyin = new Scanner(System.in);
                    String lineData = "";
                    try {
                        FileReader fr = new FileReader("work_data_original.txt");
                        BufferedReader inputStream = new BufferedReader(fr);
                        PrintWriter outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
                        String a1 = inputStream.readLine();  //�u�@�W��
                        String b1 = inputStream.readLine();  //�����ɶ�
                        String c1 = inputStream.readLine();  //�}�l�ɶ�
                        String d1 = inputStream.readLine();  //�����ʤ���
                        String e1 = inputStream.readLine();  //���A
                        String f1 = inputStream.readLine();  //�s��
                        String g1 = inputStream.readLine();  //����
                        String h1 = inputStream.readLine();  //�u�@���e
                        String i1 = inputStream.readLine();  //�~��
                        String j1 = inputStream.readLine();  //����or����
                        String k1 = inputStream.readLine();  //���j��

                        for (k = 0; (k < 300) && (a1 != null) && (b1 != null) && (c1 != null) && (d1 != null) && (e1 != null) && (f1 != null) && (g1 != null) && (h1 != null) && (i1 != null) && (j1 != null) && (k1 != null); k++) {
                            emp[k] = new Person();
                            emp[k].work = a1;
                            outputStream.println(emp[k].work);
                            a1 = inputStream.readLine();
                            emp[k].finish_time = b1;
                            outputStream.println(emp[k].finish_time);
                            b1 = inputStream.readLine();
                            emp[k].start_time = c1;
                            outputStream.println(emp[k].start_time);
                            c1 = inputStream.readLine();
                            emp[k].percent = d1;
                            outputStream.println(emp[k].percent);
                            d1 = inputStream.readLine();
                            emp[k].state = e1;
                            outputStream.println(emp[k].state);
                            e1 = inputStream.readLine();
                            emp[k].number = f1;
                            outputStream.println(emp[k].number);
                            f1 = inputStream.readLine();
                            emp[k].classify = g1;
                            outputStream.println(emp[k].classify);
                            g1 = inputStream.readLine();
                            emp[k].content = h1;
                            outputStream.println(emp[k].content);
                            h1 = inputStream.readLine();
                            emp[k].salary = i1;
                            outputStream.println(emp[k].salary);
                            i1 = inputStream.readLine();
                            emp[k].day = j1;
                            outputStream.println(emp[k].day);
                            j1 = inputStream.readLine();
                            emp[k].yo = k1;
                            outputStream.println(emp[k].yo);
                            k1 = inputStream.readLine();
                        }

                        mainMenu();
                        int select = keyin.nextInt();
                        while (select != 11) {
                            switch (select) {
                                case 1:     /* ��ܭӤH�u�@��� */
                                    disp_data();
                                    break;

                                case 2:     /* �W�[�ӤH�u�@��� */
                                    add_data();
                                    break;

                                case 3:     /* �ק�ӤH�u�@��� */
                                    modify_data();
                                    break;

                                case 4:     /* �R���ӤH�u�@��� */
                                    delete_data();
                                    break;

                                case 5:     /* �d�߭ӤH�u�@��� */
                                    search_data();
                                    break;
                                case 6:     /*�^��n�J����*/
                                    user2();
                                    break;
                                case 7:     /*�Ƨ����*/
                                    sort(s);
                                    break;
                                case 8:     /*�üƱƧ�*/
                                    shusort();
                                    break;
                                case 9:    /*�H�����ˤu�@*/
                                    random();
                                    break;
                                case 10:     /*�s��*/
                                    save();
                                    break;
                                default:
                                    System.out.printf("���~��J, �Э��s��� !!\n");
                            }
                            mainMenu();
                            select = keyin.nextInt();
                        }
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("Problem opening files.");
                    } catch (IOException e) {
                        System.out.println("Error reading from original.txt.");
                    }
                }
                else {
                    System.out.println("�n�J����!");
                    System.exit(1);
                }
                break;

            case 2:
                String InUserID2, InUserPW2; // �ϥΪ̱b���P�K�X��J
                String UserID2 = "user", UserPW2 = "1111";// �w�]�޲z�̱b���P�K�X �b���� user �K�X�� 1111
                Scanner sc = new Scanner(System.in);    // �Q�� Inp �o���ܼƦW��(�i�H�ۥѧ��) �Ө��o�ϥΪ̿�J�����

                System.out.print("�п�J�޲z�̱b���G ");
                InUserID2 = sc.nextLine();
                System.out.print("�п�J�޲z�̱K�X�G ");
                InUserPW2 = sc.nextLine();
                if (InUserID2.equals(UserID2) && InUserPW2.equals(UserPW2)) // �P�_�޲z�̱b���K�X�O�_�ҥ��T
                {
                    System.out.println("�n�J���\!");

                    Scanner keyin = new Scanner(System.in);
                    System.out.println("�аݭn�޲z���Ӷ��� => ");
                    System.out.printf("(1)(�޲z�\��)��]�w�Ѥj��p�B�Ѥp��j���\n");
                    System.out.printf("(2)(�޲z�\��)��]�w��ܨ������\n");
                    int input2 = keyin.nextInt();
                    switch(input2){
                        case 1:{
                            System.out.printf("(1)�Ѥj��p���\n(2)�Ѥp��j���\n");
                            int input3 = keyin.nextInt();
                            switch(input3){
                                case 1:
                                    s=-1;
                                    break;
                                case 2:
                                    break;
                            } break;}
                        case 2:
                            System.out.printf("\n=== �ӤH�u�@���� ===\n");
                            System.out.printf("(1) �u�@�W��   \t");
                            System.out.printf("(2) �����ɶ�   \t");
                            System.out.printf("(3) �}�l�ɶ�   \n");
                            System.out.printf("(4) �����ʤ��� \t");
                            System.out.printf("(5) ���A       \t");
                            System.out.printf("(6) �s��       \n");
                            System.out.printf("(7) ����       \t");
                            System.out.printf("(8) �u�@���e   \t");
                            System.out.printf("(9) �~��       \n");
                            System.out.printf("(10) ���鰲��  \n");
                            System.out.println("�аݭn�޲z���@�ӥ\�� => ");
                            int input = keyin.nextInt();
                            switch (input) {
                                case 1:{
				  
                                    System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        				String a = keyin.next();
        				switch (a) {
            					case "�n": break;
            					case "���n":work = false; break;
        				
    				        }
                                    }
                                    break;
                                case 2:{
                                    System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        				String a = keyin.next();
        				switch (a) {
            					case "�n": break;
            					case "���n":finish_time = false; break;
        				
    				        }
                                    }
                                    break;
                                case 3:
                                    start_time(start_time);
                                    break;
                                case 4:
                                    percent(percent);
                                    break;
                                case 5:
                                    state(state);
                                    break;
                                case 6:
                                    number(number);
                                    break;
                                case 7:
                                    classify(classify);
                                    break;
                                case 8:
                                    content(content);
                                    break;
                                case 9:
                                    salary(salary);
                                    break;
                                case 10:
                                    day(day);
                                    break;
                            }
                    }
                    user2();
                }
                else {
                    System.out.println("�n�J����!");
                    System.exit(1);
                }
                break;
        }

    }

    /*�޲z�̥\��*/
    public static boolean work(boolean work){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case "�n": break;
            case "���n":work = false; break;
        }
        return work;
    }

    public static boolean finish_time(boolean finish_time){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":finish_time = false; break;
        }
        return finish_time;
    }

    public static boolean start_time(boolean start_time){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":start_time = false;break;
        }
        return start_time;
    }

    public static boolean percent(boolean percent){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":percent = false;break;
        }
        return percent;
    }

    public static boolean state(boolean state){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":state = false; break;
        }
        return state;
    }

    public static boolean number(boolean number){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":number = false;break;
        }
        return number;
    }

    public static boolean classify(boolean classify){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":classify = false;break;
        }
        return classify;
    }

    public static boolean content(boolean content){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":content = false;break;
        }
        return content;
    }

    public static boolean salary(boolean salary){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":salary = false;break;
        }
        return salary;
    }

    public static boolean day(boolean day){
        Scanner keyin = new Scanner(System.in);
        System.out.println("�O�_�n��ܳo�ӥ\�� => ");
        String a = keyin.next();
        switch (a) {
            case  "�n": break;
            case "���n":day = false;break;
        }
        return day;
    }

    public static void user2(){
        user();
        Scanner scc = new Scanner(System.in);
        int ss = scc.nextInt();
        switch (ss) {
            case 1:
                String InUserID, InUserPW; // �ϥΪ̱b���P�K�X��J
                String UserID = "cis", UserPW = "1234"; // �w�]�ϥΪ̱b���P�K�X �b���� cis �K�X�� 1234
                Scanner Inp = new Scanner(System.in);    // �Q�� Inp �o���ܼƦW��(�i�H�ۥѧ��) �Ө��o�ϥΪ̿�J�����

                System.out.print("�п�J�ϥΪ̱b���G ");
                InUserID = Inp.nextLine();
                System.out.print("�п�J�ϥΪ̱K�X�G ");
                InUserPW = Inp.nextLine();
                if (InUserID.equals(UserID) && InUserPW.equals(UserPW)) // �P�_�b���K�X�O�_�ҥ��T
                {
                    System.out.println("�n�J���\!");

                    Scanner keyin = new Scanner(System.in);
                    String lineData = "";
                    try {
                        FileReader fr = new FileReader("work_data_original.txt");
                        BufferedReader inputStream = new BufferedReader(fr);
                        PrintWriter outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
                        String a1 = inputStream.readLine();  //�u�@�W��
                        String b1 = inputStream.readLine();  //�����ɶ�
                        String c1 = inputStream.readLine();  //�}�l�ɶ�
                        String d1 = inputStream.readLine();  //�����ʤ���
                        String e1 = inputStream.readLine();  //���A
                        String f1 = inputStream.readLine();  //�s��
                        String g1 = inputStream.readLine();  //����
                        String h1 = inputStream.readLine();  //�u�@���e
                        String i1 = inputStream.readLine();  //�~��
                        String j1 = inputStream.readLine();  //����or����
                        String k1 = inputStream.readLine();  //���j��

                        for (k = 0; (k < 300) && (a1 != null) && (b1 != null) && (c1 != null) && (d1 != null) && (e1 != null) && (f1 != null) && (g1 != null) && (h1 != null) && (i1 != null) && (j1 != null) && (k1 != null); k++) {
                            emp[k] = new Person();
                            emp[k].work = a1;
                            outputStream.println(emp[k].work);
                            a1 = inputStream.readLine();
                            emp[k].finish_time = b1;
                            outputStream.println(emp[k].finish_time);
                            b1 = inputStream.readLine();
                            emp[k].start_time = c1;
                            outputStream.println(emp[k].start_time);
                            c1 = inputStream.readLine();
                            emp[k].percent = d1;
                            outputStream.println(emp[k].percent);
                            d1 = inputStream.readLine();
                            emp[k].state = e1;
                            outputStream.println(emp[k].state);
                            e1 = inputStream.readLine();
                            emp[k].number = f1;
                            outputStream.println(emp[k].number);
                            f1 = inputStream.readLine();
                            emp[k].classify = g1;
                            outputStream.println(emp[k].classify);
                            g1 = inputStream.readLine();
                            emp[k].content = h1;
                            outputStream.println(emp[k].content);
                            h1 = inputStream.readLine();
                            emp[k].salary = i1;
                            outputStream.println(emp[k].salary);
                            i1 = inputStream.readLine();
                            emp[k].day = j1;
                            outputStream.println(emp[k].day);
                            j1 = inputStream.readLine();
                            emp[k].yo = k1;
                            outputStream.println(emp[k].yo);
                            k1 = inputStream.readLine();
                        }

                        mainMenu();
                        int select = keyin.nextInt();
                        while (select != 11) {
                            switch (select) {
                                case 1:     /* ��ܭӤH�u�@��� */
                                    disp_data();
                                    break;

                                case 2:     /* �W�[�ӤH�u�@��� */
                                    add_data();
                                    break;

                                case 3:     /* �ק�ӤH�u�@��� */
                                    modify_data();
                                    break;

                                case 4:     /* �R���ӤH�u�@��� */
                                    delete_data();
                                    break;

                                case 5:     /* �d�߭ӤH�u�@��� */
                                    search_data();
                                    break;
                                case 6:     /*�^��n�J����*/
                                    user2();
                                    break;
                                case 7:     /*�Ƨ����*/
                                    sort(s);
                                    break;
                                case 8:     /*�üƱƧ�*/
                                    shusort();
                                    break;
                                case 9:    /*�H�����ˤu�@*/
                                    random();
                                    break;
                                case 10:     /*�s��*/
                                    save();
                                    break;
                                default:
                                    System.out.printf("���~��J, �Э��s��� !!\n");
                            }
                            mainMenu();
                            select = keyin.nextInt();
                        }
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("Problem opening files.");
                    } catch (IOException e) {
                        System.out.println("Error reading from original.txt.");
                    }
                }
                else {
                    System.out.println("�n�J����!");
                    System.exit(1);
                }
                break;

            case 2:
                String InUserID2, InUserPW2; // �ϥΪ̱b���P�K�X��J
                String UserID2 = "user", UserPW2 = "1111";// �w�]�޲z�̱b���P�K�X �b���� user �K�X�� 1111
                Scanner sc = new Scanner(System.in);    // �Q�� Inp �o���ܼƦW��(�i�H�ۥѧ��) �Ө��o�ϥΪ̿�J�����

                System.out.print("�п�J�޲z�̱b���G ");
                InUserID2 = sc.nextLine();
                System.out.print("�п�J�޲z�̱K�X�G ");
                InUserPW2 = sc.nextLine();
                if (InUserID2.equals(UserID2) && InUserPW2.equals(UserPW2)) // �P�_�޲z�̱b���K�X�O�_�ҥ��T
                {
                    System.out.println("�n�J���\!");

                    Scanner keyin = new Scanner(System.in);
                    System.out.println("�аݭn�޲z���Ӷ��� => ");
                    System.out.printf("(1)(�޲z�\��)��]�w�Ѥj��p�B�Ѥp��j���\n");
                    System.out.printf("(2)(�޲z�\��)��]�w��ܨ������\n");
                    int input2 = keyin.nextInt();
                    switch(input2){
                        case 1:{
                            System.out.printf("(1)�Ѥj��p���\n(2)�Ѥp��j���\n");
                            int input3 = keyin.nextInt();
                            switch(input3){
                                case 1:
                                    s=-1;
                                    break;
                                case 2:
                                    break;
                            } break;}
                        case 2:
                            System.out.printf("\n=== �ӤH�u�@���� ===\n");
                            System.out.printf("(1) �u�@�W��   \t");
                            System.out.printf("(2) �����ɶ�   \t");
                            System.out.printf("(3) �}�l�ɶ�   \n");
                            System.out.printf("(4) �����ʤ��� \t");
                            System.out.printf("(5) ���A       \t");
                            System.out.printf("(6) �s��       \n");
                            System.out.printf("(7) ����       \t");
                            System.out.printf("(8) �u�@���e   \t");
                            System.out.printf("(9) �~��       \n");
                            System.out.printf("(10) ���鰲��  \n");
                            System.out.println("�аݭn�޲z���@�ӥ\�� => ");
                            int input = keyin.nextInt();
                            switch (input) {
                                case 1:
                                    work(work);
                                    break;
                                case 2:
                                    finish_time(finish_time);
                                    break;
                                case 3:
                                    start_time(start_time);
                                    break;
                                case 4:
                                    percent(percent);
                                    break;
                                case 5:
                                    state(state);
                                    break;
                                case 6:
                                    number(number);
                                    break;
                                case 7:
                                    classify(classify);
                                    break;
                                case 8:
                                    content(content);
                                    break;
                                case 9:
                                    salary(salary);
                                    break;
                                case 10:
                                    day(day);
                                    break;
                            }
                    }
                    user2();
                }
                else {
                    System.out.println("�n�J����!");
                    System.exit(1);
                }
                break;
        }
    }

    public static void user(){
        System.out.printf("\n=== �п�ܵn�J���� ===\n");
        System.out.printf("(1) �ϥΪ̨t��    \t");
        System.out.printf("(2) �޲z�̨t��    \n");
        System.out.printf("�п�� => ");
    }

    /*�ϥΪ̥\��*/
    public static void mainMenu() {
        System.out.printf("\n=== �ӤH��ƺ޲z�t�� ===\n");
        System.out.printf("(1) ��ܭӤH�u�@���    \t");
        System.out.printf("(2) �W�[�ӤH�u�@���    \t");
        System.out.printf("(3) �ק�ӤH�u�@���    \n");
        System.out.printf("(4) �R���ӤH�u�@���    \t");
        System.out.printf("(5) �d�߭ӤH�u�@���    \t");
        System.out.printf("(6) �^��n�J����        \n");
        System.out.printf("(7) �� �� �� ��         \t");
        System.out.printf("(8) �� �� �� ��         \t");
        System.out.printf("(9) �H�����ˤu�@        \n");
        System.out.printf("(10)�s      ��          \t");
        System.out.printf("(11)�� �} �t ��         \n");
        System.out.printf("�п�ܤu�@���� => ");
    }

    /* ��ܭӤH�u�@��� */
    public static void disp_data() {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("(����)or(����):");
        String input = keyin.next();
        switch(input){
            case "����":
                System.out.println("�O�_�n������� =>");
                String input3 = keyin.next();
                String a = "�O";
                String b = "�_";
                if(input3.equals(a))
                {
                    System.out.printf("== �����C�L�Ҧ��ӤH�u�@��� ==\n");
                    for (int i = 0; i < k; i++) {
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);

                        System.out.printf("%s\n", emp[i].yo);
                        if(i!=0 && i%3==0) {
                            System.out.println("�O�_�~��C�L");
                            String input4 = keyin.next();
                            if(input4.equals(b))
                                mainMenu();
                        }
                    }
                }


                else if(input3.equals(b))
                {
                    System.out.printf("== �C�L�Ҧ��ӤH�u�@��� ==\n");
                    for (int i = 0; i < k; i++) {
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;
            case "����":
                System.out.println("�O�_�n������� =>");
                String input5 = keyin.next();
                String c = "�O";
                String d = "�_";
                if(input5.equals(c)) {
                    System.out.printf("\n=== �ӤH�u�@���� ===\n");
                    System.out.printf("(1) �u�@�W��   \t");
                    System.out.printf("(2) �����ɶ�   \t");
                    System.out.printf("(3) �}�l�ɶ�   \n");
                    System.out.printf("(4) �����ʤ��� \t");
                    System.out.printf("(5) ���A       \t");
                    System.out.printf("(6) �s��       \n");
                    System.out.printf("(7) ����       \t");
                    System.out.printf("(8) �u�@���e   \t");
                    System.out.printf("(9) �~��       \n");
                    System.out.printf("(10) ���鰲��  \n");
                    System.out.printf("�аݭn������ܭ��@����:");
                    int input2 = keyin.nextInt();
                    switch (input2) {
                        case 1:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].work);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 2:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].finish_time);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 3:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].start_time);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 4:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].percent);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 5:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].state);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 6:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].number);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 7:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].classify);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 8:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].content);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 9:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].salary);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 10:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].day);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("�O�_�~��C�L");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                    }
                }
                else if (input5.equals(d)) {
                    System.out.printf("\n=== �ӤH�u�@���� ===\n");
                    System.out.printf("(1) �u�@�W��   \t");
                    System.out.printf("(2) �����ɶ�   \t");
                    System.out.printf("(3) �}�l�ɶ�   \n");
                    System.out.printf("(4) �����ʤ��� \t");
                    System.out.printf("(5) ���A       \t");
                    System.out.printf("(6) �s��       \n");
                    System.out.printf("(7) ����       \t");
                    System.out.printf("(8) �u�@���e   \t");
                    System.out.printf("(9) �~��       \n");
                    System.out.printf("(10) ���鰲��  \n");
                    System.out.printf("�аݭn��ܭ��@����:");
                    int input6 = keyin.nextInt();
                    switch (input6) {
                        case 1:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].work);
                            }break;
                        case 2:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].finish_time);
                            }break;
                        case 3:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].start_time);
                            }break;
                        case 4:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].percent);
                            }break;
                        case 5:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].state);
                            }break;
                        case 6:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].number);
                            }break;
                        case 7:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].classify);
                            }break;
                        case 8:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].content);
                            }break;
                        case 9:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].salary);
                            }break;
                        case 10:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].day);
                            }break;
                    }
                }
        }
    }


    /* �W�[�ӤH�u�@��� */
    public static void add_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        emp[k] = new Person();
        System.out.printf("�п�J�u�@�W�� =>");
        emp[k].work = "�u�@�W�� :"+keyin.next();
        //keyin.nextLine();          //�M����L�w�ľ�
        System.out.printf("�п�J�����ɶ� =>");
        emp[k].finish_time = "�����ɶ� =>"+keyin.next();
        System.out.printf("�п�J�}�l�ɶ� =>");
        emp[k].start_time = "�}�l�ɶ� :"+keyin.next();
        System.out.printf("�п�J�����ʤ���=>");
        emp[k].percent = "�����ʤ��� :"+keyin.next();
        System.out.printf("�п�J���A =>");
        emp[k].state = "���A :"+keyin.next();
        System.out.printf("�п�J�s�� =>");
        emp[k].number = "�s�� :"+keyin.next();
        System.out.printf("�п�J���� =>:");
        emp[k].classify = "���� :"+keyin.next();
        System.out.printf("�п�J�u�@���e =>");
        emp[k].content = "�u�@���e :"+keyin.next();
        System.out.printf("�п�J�~�� =>");
        emp[k].salary = "�~�� :"+keyin.next();
        System.out.printf("�п�J����or���� =>");
        emp[k].day = "����or���� :"+keyin.next();
        System.out.printf("���j��  =>");
        emp[k].yo = keyin.next();
        k = k+1;
    }

    /* �ק�ӤH�u�@��� */
    public static void modify_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("�п�J���ק�ӤH�u�@���W�� =>");
        String work2 = keyin.next();
        System.out.printf("------------------------------\n");
        keyin.nextLine();          //�M����L�w�ľ�
        int flag = 0;
        int i = 0;
        while(i < k) {
            if (emp[i].work.indexOf(work2)>-1) {
                flag = 1;
                break;
            }
            i = i + 1;
        }

        if (flag == 0) {
            System.out.printf("test here 5\n");
            System.out.printf("�S�� %s ���, �ڵ��B�z !!\n", work2);
            return;
        }
        System.out.printf("�п�J��粒���u�@�W�� =>");
        emp[i].work = "�u�@�W�� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒�������ɶ� =>");
        emp[i].finish_time = "�����ɶ� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒���}�l�ɶ� =>");
        emp[i].start_time = "�}�l�ɶ� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒�������ʤ��� =>");
        emp[i].percent = "�����ʤ��� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒�����A =>");
        emp[i].state = "���A =>"+keyin.nextLine();
        System.out.printf("�п�J��粒���s�� =>");
        emp[i].classify = "�s�� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒������ =>");
        emp[i].content = "���� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒���~�� =>");
        emp[i].salary = "�~�� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒������or���� =>");
        emp[i].day = "����or���� =>"+keyin.nextLine();
        System.out.printf("�п�J��粒�����j�� =>");
        emp[i].yo = keyin.nextLine();
    }

    /* �R����� */
    public static void delete_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("�п�J���R���ӤH�u�@���W�� =>");
        String work2 = keyin.next();
        int flag = 0, m = 0;
        while(m < k) {
            if (emp[m].work.indexOf(work2)>-1){
                flag = 1;
                break;
            }
            m = m + 1;
        }

        if (flag == 0){
            System.out.printf("�S�� %s ���, �ڵ��B�z !!\n", work2);
            return;
        }
        for(int i=m; i<k; i++)
            emp[i]=emp[i+1];
        k = k-1;
        System.out.printf("%s ��Ƥw�R�� !!\n", work2);
    }

    /* �d�߭ӤH�u�@��� */
    public static void search_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("�аݭn�d�߭��Ӥu�@����=>\n");
        System.out.printf("(1) �ӤH�u�@�W��   \t");
        System.out.printf("(2) �ӤH�����ɶ�   \t");
        System.out.printf("(3) �ӤH�}�l�ɶ�   \t");
        System.out.printf("(4) �ӤH�����ʤ��� \n");
        System.out.printf("(5) �ӤH���A       \t");
        System.out.printf("(6) �ӤH�s��       \t");
        System.out.printf("(7) �ӤH����       \t");
        System.out.printf("(8) �u�@���e       \n");
        System.out.printf("(9) �~   ��        \t");
        System.out.printf("(10)����or����     \t");

        int in = keyin.nextInt();
        String in2;
        switch(in){
            case 1:
                System.out.printf("�аݭn�d�߭��Ӥu�@�W��:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].work.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 2:
                System.out.printf("�аݭn�d�߭��ӧ����ɶ�:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].finish_time.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 3:
                System.out.printf("�аݭn�d�߭��Ӷ}�l�ɶ�:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].start_time.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 4:
                System.out.printf("�аݭn�d�ߦh�֦ʤ���:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].percent.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 5:
                System.out.printf("�аݭn�d�߭��Ӫ��A:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].state.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 6:
                System.out.printf("�аݭn�d�߭��ӽs��:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].number.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 7:
                System.out.printf("�аݭn�d�߭��Ӥ���:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].classify.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;

            case 8:
                System.out.printf("�аݭn�d�߭��Ӥu�@���e:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].content.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;
            case 9:
                System.out.printf("�аݭn�d�ߦh���~��:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].salary.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;
            case 10:
                System.out.printf("�аݭn�d�߭��ӥ���or����:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].day.indexOf(in2)>-1){
                        System.out.printf("== �C�L�ӤH�u�@��� ==\n");
                        if(work == true)
                            System.out.printf("%s\n", emp[i].work);
                        if(finish_time == true)
                            System.out.printf("%s\n", emp[i].finish_time);
                        if(start_time == true)
                            System.out.printf("%s\n", emp[i].start_time);
                        if(percent == true)
                            System.out.printf("%s\n", emp[i].percent);
                        if(state == true)
                            System.out.printf("%s\n", emp[i].state);
                        if(number == true)
                            System.out.printf("%s\n", emp[i].number);
                        if(classify == true)
                            System.out.printf("%s\n", emp[i].classify);
                        if(content == true)
                            System.out.printf("%s\n", emp[i].content);
                        if(salary == true)
                            System.out.printf("%s\n", emp[i].salary);
                        if(day == true)
                            System.out.printf("%s\n", emp[i].day);
                        System.out.printf("%s\n", emp[i].yo);
                    }
                }break;
        }
    }

    /*�Ƨ����*/
    public  static void sort(int s) {
        String temp = "",temp1="",temp2="",temp3="",temp4="",temp5="",temp6="",temp7="",temp8="",temp9="";

        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < k - 1; ++j) {
                if ((Integer.parseInt(emp[j].percent.substring(6)))*s > (Integer.parseInt(emp[j + 1].percent.substring(6)))*s)
                {
                    temp = emp[j].percent;
                    emp[j].percent = emp[j + 1].percent;
                    emp[j + 1].percent = temp;
                    temp1 = emp[j].work;
                    emp[j].work = emp[j + 1].work;
                    emp[j + 1].work = temp1;
                    temp2 = emp[j].finish_time;
                    emp[j].finish_time = emp[j + 1].finish_time;
                    emp[j + 1].finish_time = temp2;
                    temp3 = emp[j].start_time;
                    emp[j].start_time = emp[j + 1].start_time;
                    emp[j + 1].start_time = temp3;
                    temp4 = emp[j].state;
                    emp[j].state = emp[j + 1].state;
                    emp[j + 1].state = temp4;
                    temp5 = emp[j].number;
                    emp[j].number = emp[j + 1].number;
                    emp[j + 1].number = temp5;
                    temp6 = emp[j].classify;
                    emp[j].classify = emp[j + 1].classify;
                    emp[j + 1].classify = temp6;
                    temp7 = emp[j].content;
                    emp[j].content = emp[j + 1].content;
                    emp[j + 1].content = temp7;
                    temp8 = emp[j].salary;
                    emp[j].salary = emp[j + 1].salary;
                    emp[j + 1].salary = temp8;
                    temp9 = emp[j].day;
                    emp[j].day = emp[j + 1].day;
                    emp[j + 1].day = temp9;
                }
            }
        }

        Scanner keyin = new Scanner(System.in);
        System.out.println("(1)���� or (2)����");
        int input =keyin.nextInt();
        switch(input) {
            case 1:
                for (int i = 0; i < k; ++i) {
                    if (work == true)
                        System.out.printf("%s\n", emp[i].work);
                    if (finish_time == true)
                        System.out.printf("%s\n", emp[i].finish_time);
                    if (start_time == true)
                        System.out.printf("%s\n", emp[i].start_time);
                    if (percent == true)
                        System.out.printf("%s\n", emp[i].percent);
                    if (state == true)
                        System.out.printf("%s\n", emp[i].state);
                    if (number == true)
                        System.out.printf("%s\n", emp[i].number);
                    if (classify == true)
                        System.out.printf("%s\n", emp[i].classify);
                    if (content == true)
                        System.out.printf("%s\n", emp[i].content);
                    if (salary == true)
                        System.out.printf("%s\n", emp[i].salary);
                    if (day == true)
                        System.out.printf("%s\n", emp[i].day);

                    System.out.printf("%s\n", emp[i].yo);
                }break;

            case 2:
                System.out.printf("\n=== �ӤH�u�@���� <<�̷ӽs�����Ƨ�>> ===\n");
                System.out.printf("(1) �u�@�W��   \t");
                System.out.printf("(2) �����ɶ�   \t");
                System.out.printf("(3) �}�l�ɶ�   \n");
                System.out.printf("(4) �����ʤ��� \t");
                System.out.printf("(5) ���A       \t");
                System.out.printf("(6) �s��       \n");
                System.out.printf("(7) ����       \t");
                System.out.printf("(8) �u�@���e   \t");
                System.out.printf("(9) �~��       \n");
                System.out.printf("(10)���鰲��   \n");
                System.out.println("�аݭn��ܭ��@�ӥ\�� => ");
                int input2 = keyin.nextInt();
                switch (input2) {
                    case 1:
                        for (int i = 0; i < k; ++i) {
                            if (work == true)
                                System.out.printf("%s\n", emp[i].work);
                        }
                        break;
                    case 2:
                        for (int i = 0; i < k; ++i) {
                            if (finish_time == true)
                                System.out.printf("%s\n", emp[i].finish_time);
                        }
                        break;
                    case 3:
                        for (int i = 0; i < k; ++i) {
                            if (start_time == true)
                                System.out.printf("%s\n", emp[i].start_time);
                        }
                        break;
                    case 4:
                        for (int i = 0; i < k; ++i) {
                            if (percent == true)
                                System.out.printf("%s\n", emp[i].percent);
                        }
                        break;
                    case 5:
                        for (int i = 0; i < k; ++i) {
                            if (state == true)
                                System.out.printf("%s\n", emp[i].state);
                        }
                        break;
                    case 6:
                        for (int i = 0; i < k; ++i) {
                            if (number == true)
                                System.out.printf("%s\n", emp[i].number);
                        }
                        break;
                    case 7:
                        for (int i = 0; i < k; ++i) {
                            if (classify == true)
                                System.out.printf("%s\n", emp[i].classify);
                        }
                        break;
                    case 8:
                        for (int i = 0; i < k; ++i) {
                            if (content == true)
                                System.out.printf("%s\n", emp[i].content);
                        }
                        break;
                    case 9:
                        for (int i = 0; i < k; ++i) {
                            if (salary == true)
                                System.out.printf("%s\n", emp[i].salary);
                        }
                        break;
                    case 10:
                        for (int i = 0; i < k; ++i) {
                            if (day == true)
                                System.out.printf("%s\n", emp[i].day);
                        }
                        break;
                }
        }
    }

    /*�H�����ˤu�@*/
    public static void random()
    {
        int todaypush=(int)(Math.random()*k);
        System.out.println("==============�H�����ˤu�@==============");
        System.out.println(emp[todaypush].work);
        System.out.println(emp[todaypush].finish_time);
        System.out.println(emp[todaypush].start_time);
        System.out.println(emp[todaypush].percent);
        System.out.println(emp[todaypush].state);
        System.out.println(emp[todaypush].number);
        System.out.println(emp[todaypush].classify);
        System.out.println(emp[todaypush].content);
        System.out.println(emp[todaypush].salary);
        System.out.println(emp[todaypush].day);
        System.out.println(emp[todaypush].yo);
    }
    /*�üƱƧ�*/
    public static void shusort()
    {
        Scanner scc = new Scanner(System.in);
        ArrayList<String> arraylist =new ArrayList<String>();

        for(int i=0; i<k; i++) {
            arraylist.add(emp[i].work);
            arraylist.add(emp[i].finish_time);
            arraylist.add(emp[i].start_time);
            arraylist.add(emp[i].percent);
            arraylist.add(emp[i].state);
            arraylist.add(emp[i].number);
            arraylist.add(emp[i].classify);
            arraylist.add(emp[i].content);
            arraylist.add(emp[i].salary);
            arraylist.add(emp[i].day);


        }
        Collections.shuffle(arraylist);
        for(String result:arraylist)
        {
            System.out.println(result);
        }

    }

    /*�s��*/
    public static void save()
    {
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("work_data_original.txt"));
            for (int i = 0; i < k ; i++){
                write.println(emp[i].work);
                write.println(emp[i].finish_time);
                write.println(emp[i].start_time);
                write.println(emp[i].percent);
                write.println(emp[i].state);
                write.println(emp[i].number);
                write.println(emp[i].classify);
                write.println(emp[i].content);
                write.println(emp[i].salary);
                write.println(emp[i].day);
                write.println(emp[i].yo);
            }
            System.out.println("�s�ɦ��\");
            write.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening files.");
            System.exit(0);
        }
    }
}







