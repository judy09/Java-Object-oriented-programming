import java.util.Scanner; // 匯入名稱為 Scanner 的模組 (使用來取得使用者輸入的資料)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

class Main // 專案名稱_ExUser (記得要跟檔案名稱相同)
{

    //static Person[] emp;         // 員工資料的物件陣列
    static int k=0;                // 紀錄儲存筆數
    static Person [] emp = new Person[300];
    static boolean work =true , finish_time = true, start_time = true , percent = true,state = true, number = true,classify = true, content = true, salary = true ,day = true;
    static int s = 1;
    public static void main(String[] args)throws IOException {
        user();
        Scanner scc = new Scanner(System.in);
        int ss = scc.nextInt();
        switch (ss) {
            case 1:
                String InUserID, InUserPW; // 使用者帳號與密碼輸入
                String UserID = "cis", UserPW = "1234"; // 預設使用者帳號與密碼 帳號為 cis 密碼為 1234
                Scanner Inp = new Scanner(System.in);    // 利用 Inp 這個變數名稱(可以自由更改) 來取得使用者輸入的資料

                System.out.print("請輸入使用者帳號： ");
                InUserID = Inp.nextLine();
                System.out.print("請輸入使用者密碼： ");
                InUserPW = Inp.nextLine();
                if (InUserID.equals(UserID) && InUserPW.equals(UserPW)) // 判斷帳號密碼是否皆正確
                {
                    System.out.println("登入成功!");

                    Scanner keyin = new Scanner(System.in);
                    String lineData = "";
                    try {
                        FileReader fr = new FileReader("work_data_original.txt");
                        BufferedReader inputStream = new BufferedReader(fr);
                        PrintWriter outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
                        String a1 = inputStream.readLine();  //工作名稱
                        String b1 = inputStream.readLine();  //完成時間
                        String c1 = inputStream.readLine();  //開始時間
                        String d1 = inputStream.readLine();  //完成百分比
                        String e1 = inputStream.readLine();  //狀態
                        String f1 = inputStream.readLine();  //編號
                        String g1 = inputStream.readLine();  //分類
                        String h1 = inputStream.readLine();  //工作內容
                        String i1 = inputStream.readLine();  //薪水
                        String j1 = inputStream.readLine();  //假日or平日
                        String k1 = inputStream.readLine();  //分隔號

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
                                case 1:     /* 顯示個人工作資料 */
                                    disp_data();
                                    break;

                                case 2:     /* 增加個人工作資料 */
                                    add_data();
                                    break;

                                case 3:     /* 修改個人工作資料 */
                                    modify_data();
                                    break;

                                case 4:     /* 刪除個人工作資料 */
                                    delete_data();
                                    break;

                                case 5:     /* 查詢個人工作資料 */
                                    search_data();
                                    break;
                                case 6:     /*回到登入頁面*/
                                    user2();
                                    break;
                                case 7:     /*排序顯示*/
                                    sort(s);
                                    break;
                                case 8:     /*亂數排序*/
                                    shusort();
                                    break;
                                case 9:    /*隨機推薦工作*/
                                    random();
                                    break;
                                case 10:     /*存檔*/
                                    save();
                                    break;
                                default:
                                    System.out.printf("錯誤輸入, 請重新選擇 !!\n");
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
                    System.out.println("登入失敗!");
                    System.exit(1);
                }
                break;

            case 2:
                String InUserID2, InUserPW2; // 使用者帳號與密碼輸入
                String UserID2 = "user", UserPW2 = "1111";// 預設管理者帳號與密碼 帳號為 user 密碼為 1111
                Scanner sc = new Scanner(System.in);    // 利用 Inp 這個變數名稱(可以自由更改) 來取得使用者輸入的資料

                System.out.print("請輸入管理者帳號： ");
                InUserID2 = sc.nextLine();
                System.out.print("請輸入管理者密碼： ");
                InUserPW2 = sc.nextLine();
                if (InUserID2.equals(UserID2) && InUserPW2.equals(UserPW2)) // 判斷管理者帳號密碼是否皆正確
                {
                    System.out.println("登入成功!");

                    Scanner keyin = new Scanner(System.in);
                    System.out.println("請問要管理哪個項目 => ");
                    System.out.printf("(1)(管理功能)能設定由大到小、由小到大顯示\n");
                    System.out.printf("(2)(管理功能)能設定顯示那些欄位\n");
                    int input2 = keyin.nextInt();
                    switch(input2){
                        case 1:{
                            System.out.printf("(1)由大到小顯示\n(2)由小到大顯示\n");
                            int input3 = keyin.nextInt();
                            switch(input3){
                                case 1:
                                    s=-1;
                                    break;
                                case 2:
                                    break;
                            } break;}
                        case 2:
                            System.out.printf("\n=== 個人工作項目 ===\n");
                            System.out.printf("(1) 工作名稱   \t");
                            System.out.printf("(2) 完成時間   \t");
                            System.out.printf("(3) 開始時間   \n");
                            System.out.printf("(4) 完成百分比 \t");
                            System.out.printf("(5) 狀態       \t");
                            System.out.printf("(6) 編號       \n");
                            System.out.printf("(7) 分類       \t");
                            System.out.printf("(8) 工作內容   \t");
                            System.out.printf("(9) 薪水       \n");
                            System.out.printf("(10) 平日假日  \n");
                            System.out.println("請問要管理哪一個功能 => ");
                            int input = keyin.nextInt();
                            switch (input) {
                                case 1:{
				  
                                    System.out.println("是否要顯示這個功能 => ");
        				String a = keyin.next();
        				switch (a) {
            					case "要": break;
            					case "不要":work = false; break;
        				
    				        }
                                    }
                                    break;
                                case 2:{
                                    System.out.println("是否要顯示這個功能 => ");
        				String a = keyin.next();
        				switch (a) {
            					case "要": break;
            					case "不要":finish_time = false; break;
        				
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
                    System.out.println("登入失敗!");
                    System.exit(1);
                }
                break;
        }

    }

    /*管理者功能*/
    public static boolean work(boolean work){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case "要": break;
            case "不要":work = false; break;
        }
        return work;
    }

    public static boolean finish_time(boolean finish_time){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":finish_time = false; break;
        }
        return finish_time;
    }

    public static boolean start_time(boolean start_time){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":start_time = false;break;
        }
        return start_time;
    }

    public static boolean percent(boolean percent){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":percent = false;break;
        }
        return percent;
    }

    public static boolean state(boolean state){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":state = false; break;
        }
        return state;
    }

    public static boolean number(boolean number){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":number = false;break;
        }
        return number;
    }

    public static boolean classify(boolean classify){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":classify = false;break;
        }
        return classify;
    }

    public static boolean content(boolean content){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":content = false;break;
        }
        return content;
    }

    public static boolean salary(boolean salary){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":salary = false;break;
        }
        return salary;
    }

    public static boolean day(boolean day){
        Scanner keyin = new Scanner(System.in);
        System.out.println("是否要顯示這個功能 => ");
        String a = keyin.next();
        switch (a) {
            case  "要": break;
            case "不要":day = false;break;
        }
        return day;
    }

    public static void user2(){
        user();
        Scanner scc = new Scanner(System.in);
        int ss = scc.nextInt();
        switch (ss) {
            case 1:
                String InUserID, InUserPW; // 使用者帳號與密碼輸入
                String UserID = "cis", UserPW = "1234"; // 預設使用者帳號與密碼 帳號為 cis 密碼為 1234
                Scanner Inp = new Scanner(System.in);    // 利用 Inp 這個變數名稱(可以自由更改) 來取得使用者輸入的資料

                System.out.print("請輸入使用者帳號： ");
                InUserID = Inp.nextLine();
                System.out.print("請輸入使用者密碼： ");
                InUserPW = Inp.nextLine();
                if (InUserID.equals(UserID) && InUserPW.equals(UserPW)) // 判斷帳號密碼是否皆正確
                {
                    System.out.println("登入成功!");

                    Scanner keyin = new Scanner(System.in);
                    String lineData = "";
                    try {
                        FileReader fr = new FileReader("work_data_original.txt");
                        BufferedReader inputStream = new BufferedReader(fr);
                        PrintWriter outputStream = new PrintWriter(new FileOutputStream("numbered.txt"));
                        String a1 = inputStream.readLine();  //工作名稱
                        String b1 = inputStream.readLine();  //完成時間
                        String c1 = inputStream.readLine();  //開始時間
                        String d1 = inputStream.readLine();  //完成百分比
                        String e1 = inputStream.readLine();  //狀態
                        String f1 = inputStream.readLine();  //編號
                        String g1 = inputStream.readLine();  //分類
                        String h1 = inputStream.readLine();  //工作內容
                        String i1 = inputStream.readLine();  //薪水
                        String j1 = inputStream.readLine();  //假日or平日
                        String k1 = inputStream.readLine();  //分隔號

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
                                case 1:     /* 顯示個人工作資料 */
                                    disp_data();
                                    break;

                                case 2:     /* 增加個人工作資料 */
                                    add_data();
                                    break;

                                case 3:     /* 修改個人工作資料 */
                                    modify_data();
                                    break;

                                case 4:     /* 刪除個人工作資料 */
                                    delete_data();
                                    break;

                                case 5:     /* 查詢個人工作資料 */
                                    search_data();
                                    break;
                                case 6:     /*回到登入頁面*/
                                    user2();
                                    break;
                                case 7:     /*排序顯示*/
                                    sort(s);
                                    break;
                                case 8:     /*亂數排序*/
                                    shusort();
                                    break;
                                case 9:    /*隨機推薦工作*/
                                    random();
                                    break;
                                case 10:     /*存檔*/
                                    save();
                                    break;
                                default:
                                    System.out.printf("錯誤輸入, 請重新選擇 !!\n");
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
                    System.out.println("登入失敗!");
                    System.exit(1);
                }
                break;

            case 2:
                String InUserID2, InUserPW2; // 使用者帳號與密碼輸入
                String UserID2 = "user", UserPW2 = "1111";// 預設管理者帳號與密碼 帳號為 user 密碼為 1111
                Scanner sc = new Scanner(System.in);    // 利用 Inp 這個變數名稱(可以自由更改) 來取得使用者輸入的資料

                System.out.print("請輸入管理者帳號： ");
                InUserID2 = sc.nextLine();
                System.out.print("請輸入管理者密碼： ");
                InUserPW2 = sc.nextLine();
                if (InUserID2.equals(UserID2) && InUserPW2.equals(UserPW2)) // 判斷管理者帳號密碼是否皆正確
                {
                    System.out.println("登入成功!");

                    Scanner keyin = new Scanner(System.in);
                    System.out.println("請問要管理哪個項目 => ");
                    System.out.printf("(1)(管理功能)能設定由大到小、由小到大顯示\n");
                    System.out.printf("(2)(管理功能)能設定顯示那些欄位\n");
                    int input2 = keyin.nextInt();
                    switch(input2){
                        case 1:{
                            System.out.printf("(1)由大到小顯示\n(2)由小到大顯示\n");
                            int input3 = keyin.nextInt();
                            switch(input3){
                                case 1:
                                    s=-1;
                                    break;
                                case 2:
                                    break;
                            } break;}
                        case 2:
                            System.out.printf("\n=== 個人工作項目 ===\n");
                            System.out.printf("(1) 工作名稱   \t");
                            System.out.printf("(2) 完成時間   \t");
                            System.out.printf("(3) 開始時間   \n");
                            System.out.printf("(4) 完成百分比 \t");
                            System.out.printf("(5) 狀態       \t");
                            System.out.printf("(6) 編號       \n");
                            System.out.printf("(7) 分類       \t");
                            System.out.printf("(8) 工作內容   \t");
                            System.out.printf("(9) 薪水       \n");
                            System.out.printf("(10) 平日假日  \n");
                            System.out.println("請問要管理哪一個功能 => ");
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
                    System.out.println("登入失敗!");
                    System.exit(1);
                }
                break;
        }
    }

    public static void user(){
        System.out.printf("\n=== 請選擇登入頁面 ===\n");
        System.out.printf("(1) 使用者系統    \t");
        System.out.printf("(2) 管理者系統    \n");
        System.out.printf("請選擇 => ");
    }

    /*使用者功能*/
    public static void mainMenu() {
        System.out.printf("\n=== 個人資料管理系統 ===\n");
        System.out.printf("(1) 顯示個人工作資料    \t");
        System.out.printf("(2) 增加個人工作資料    \t");
        System.out.printf("(3) 修改個人工作資料    \n");
        System.out.printf("(4) 刪除個人工作資料    \t");
        System.out.printf("(5) 查詢個人工作資料    \t");
        System.out.printf("(6) 回到登入頁面        \n");
        System.out.printf("(7) 排 序 顯 示         \t");
        System.out.printf("(8) 亂 數 排 序         \t");
        System.out.printf("(9) 隨機推薦工作        \n");
        System.out.printf("(10)存      檔          \t");
        System.out.printf("(11)離 開 系 統         \n");
        System.out.printf("請選擇工作項目 => ");
    }

    /* 顯示個人工作資料 */
    public static void disp_data() {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("(全部)or(部分):");
        String input = keyin.next();
        switch(input){
            case "全部":
                System.out.println("是否要分頁顯示 =>");
                String input3 = keyin.next();
                String a = "是";
                String b = "否";
                if(input3.equals(a))
                {
                    System.out.printf("== 分頁列印所有個人工作資料 ==\n");
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
                            System.out.println("是否繼續列印");
                            String input4 = keyin.next();
                            if(input4.equals(b))
                                mainMenu();
                        }
                    }
                }


                else if(input3.equals(b))
                {
                    System.out.printf("== 列印所有個人工作資料 ==\n");
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
            case "部分":
                System.out.println("是否要分頁顯示 =>");
                String input5 = keyin.next();
                String c = "是";
                String d = "否";
                if(input5.equals(c)) {
                    System.out.printf("\n=== 個人工作項目 ===\n");
                    System.out.printf("(1) 工作名稱   \t");
                    System.out.printf("(2) 完成時間   \t");
                    System.out.printf("(3) 開始時間   \n");
                    System.out.printf("(4) 完成百分比 \t");
                    System.out.printf("(5) 狀態       \t");
                    System.out.printf("(6) 編號       \n");
                    System.out.printf("(7) 分類       \t");
                    System.out.printf("(8) 工作內容   \t");
                    System.out.printf("(9) 薪水       \n");
                    System.out.printf("(10) 平日假日  \n");
                    System.out.printf("請問要分頁顯示哪一部分:");
                    int input2 = keyin.nextInt();
                    switch (input2) {
                        case 1:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].work);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 2:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].finish_time);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 3:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].start_time);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 4:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].percent);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 5:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].state);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 6:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].number);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 7:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].classify);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 8:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].content);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 9:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].salary);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                        case 10:
                            for (int i = 0; i < k; i++) {
                                System.out.printf("%s\n", emp[i].day);
                                if (i != 0 && i % 3 == 0) {
                                    System.out.println("是否繼續列印");
                                    String input4 = keyin.next();
                                    if (input4.equals(d))
                                        mainMenu();
                                }
                            }break;
                    }
                }
                else if (input5.equals(d)) {
                    System.out.printf("\n=== 個人工作項目 ===\n");
                    System.out.printf("(1) 工作名稱   \t");
                    System.out.printf("(2) 完成時間   \t");
                    System.out.printf("(3) 開始時間   \n");
                    System.out.printf("(4) 完成百分比 \t");
                    System.out.printf("(5) 狀態       \t");
                    System.out.printf("(6) 編號       \n");
                    System.out.printf("(7) 分類       \t");
                    System.out.printf("(8) 工作內容   \t");
                    System.out.printf("(9) 薪水       \n");
                    System.out.printf("(10) 平日假日  \n");
                    System.out.printf("請問要顯示哪一部分:");
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


    /* 增加個人工作資料 */
    public static void add_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        emp[k] = new Person();
        System.out.printf("請輸入工作名稱 =>");
        emp[k].work = "工作名稱 :"+keyin.next();
        //keyin.nextLine();          //清除鍵盤緩衝器
        System.out.printf("請輸入完成時間 =>");
        emp[k].finish_time = "完成時間 =>"+keyin.next();
        System.out.printf("請輸入開始時間 =>");
        emp[k].start_time = "開始時間 :"+keyin.next();
        System.out.printf("請輸入完成百分比=>");
        emp[k].percent = "完成百分比 :"+keyin.next();
        System.out.printf("請輸入狀態 =>");
        emp[k].state = "狀態 :"+keyin.next();
        System.out.printf("請輸入編號 =>");
        emp[k].number = "編號 :"+keyin.next();
        System.out.printf("請輸入分類 =>:");
        emp[k].classify = "分類 :"+keyin.next();
        System.out.printf("請輸入工作內容 =>");
        emp[k].content = "工作內容 :"+keyin.next();
        System.out.printf("請輸入薪水 =>");
        emp[k].salary = "薪水 :"+keyin.next();
        System.out.printf("請輸入假日or平日 =>");
        emp[k].day = "假日or平日 :"+keyin.next();
        System.out.printf("分隔號  =>");
        emp[k].yo = keyin.next();
        k = k+1;
    }

    /* 修改個人工作資料 */
    public static void modify_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("請輸入欲修改個人工作的名稱 =>");
        String work2 = keyin.next();
        System.out.printf("------------------------------\n");
        keyin.nextLine();          //清除鍵盤緩衝器
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
            System.out.printf("沒有 %s 資料, 拒絕處理 !!\n", work2);
            return;
        }
        System.out.printf("請輸入更改完的工作名稱 =>");
        emp[i].work = "工作名稱 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的完成時間 =>");
        emp[i].finish_time = "完成時間 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的開始時間 =>");
        emp[i].start_time = "開始時間 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的完成百分比 =>");
        emp[i].percent = "完成百分比 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的狀態 =>");
        emp[i].state = "狀態 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的編號 =>");
        emp[i].classify = "編號 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的分類 =>");
        emp[i].content = "分類 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的薪水 =>");
        emp[i].salary = "薪水 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的假日or平日 =>");
        emp[i].day = "假日or平日 =>"+keyin.nextLine();
        System.out.printf("請輸入更改完的分隔號 =>");
        emp[i].yo = keyin.nextLine();
    }

    /* 刪除資料 */
    public static void delete_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("請輸入欲刪除個人工作的名稱 =>");
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
            System.out.printf("沒有 %s 資料, 拒絕處理 !!\n", work2);
            return;
        }
        for(int i=m; i<k; i++)
            emp[i]=emp[i+1];
        k = k-1;
        System.out.printf("%s 資料已刪除 !!\n", work2);
    }

    /* 查詢個人工作資料 */
    public static void search_data() throws IOException {
        Scanner keyin = new Scanner(System.in);
        System.out.printf("請問要查詢哪個工作項目=>\n");
        System.out.printf("(1) 個人工作名稱   \t");
        System.out.printf("(2) 個人完成時間   \t");
        System.out.printf("(3) 個人開始時間   \t");
        System.out.printf("(4) 個人完成百分比 \n");
        System.out.printf("(5) 個人狀態       \t");
        System.out.printf("(6) 個人編號       \t");
        System.out.printf("(7) 個人分類       \t");
        System.out.printf("(8) 工作內容       \n");
        System.out.printf("(9) 薪   水        \t");
        System.out.printf("(10)假日or平日     \t");

        int in = keyin.nextInt();
        String in2;
        switch(in){
            case 1:
                System.out.printf("請問要查詢哪個工作名稱:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].work.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個完成時間:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].finish_time.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個開始時間:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].start_time.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢多少百分比:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].percent.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個狀態:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].state.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個編號:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].number.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個分類:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].classify.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個工作內容:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].content.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢多少薪水:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].salary.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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
                System.out.printf("請問要查詢哪個平日or假日:");
                in2 = keyin.next();
                for (int i=0; i<k; i++) {
                    if(emp[i].day.indexOf(in2)>-1){
                        System.out.printf("== 列印個人工作資料 ==\n");
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

    /*排序顯示*/
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
        System.out.println("(1)全部 or (2)部分");
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
                System.out.printf("\n=== 個人工作項目 <<依照編號做排序>> ===\n");
                System.out.printf("(1) 工作名稱   \t");
                System.out.printf("(2) 完成時間   \t");
                System.out.printf("(3) 開始時間   \n");
                System.out.printf("(4) 完成百分比 \t");
                System.out.printf("(5) 狀態       \t");
                System.out.printf("(6) 編號       \n");
                System.out.printf("(7) 分類       \t");
                System.out.printf("(8) 工作內容   \t");
                System.out.printf("(9) 薪水       \n");
                System.out.printf("(10)平日假日   \n");
                System.out.println("請問要顯示哪一個功能 => ");
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

    /*隨機推薦工作*/
    public static void random()
    {
        int todaypush=(int)(Math.random()*k);
        System.out.println("==============隨機推薦工作==============");
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
    /*亂數排序*/
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

    /*存檔*/
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
            System.out.println("存檔成功");
            write.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem opening files.");
            System.exit(0);
        }
    }
}







