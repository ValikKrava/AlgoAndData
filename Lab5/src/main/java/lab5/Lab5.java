package lab5;

public class Lab5 {
    public static void main(String[] args) {

        String phone = "(+380)50-333-33-33";
        String regexPhone = "^\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}$";
        System.out.println(phone.matches(regexPhone));


        String str = "Я хочу    бути     програмістом";
        String regexSpaces = "\\s{2,}";
        String replacement = " ";
        String result = str.replaceAll(regexSpaces, replacement);
        System.out.println(result);


        String html =
                "<div>\n" +
                        "<p>Символи круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи " +
                        "дозволяють отримати з рядка додаткову інформацію.\n" +
                        "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію " +
                        "за заданим виразом і знаходить її - він просто повертає " +
                        "знайдений рядок.</p>\n" +
                        "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                        "</div>";
        String regexHtml = "<[^>]*>";
        String resultHtml = html.replaceAll(regexHtml, "");

        System.out.println(resultHtml);
    }
}
