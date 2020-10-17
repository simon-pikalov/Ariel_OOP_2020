/**
 * This simple class tester performs few "testing" over the FormCalculator class
 * the testers includes:
 * 1. (test1): few good / bad examples;
 * 2. (test2): a complex isForm example for testing that some complex form is actually in the proper form/
 * 3. (test3): a complex value of a From.
 */
public class FormCalculatorTest {
    public static String[] good_forms = {"3", "(-3)", "((1.5))", "(1.5*4)", "(2.5*(4-2))"};
    public static String[] bad_forms = {"*3", "(-3", "(1.3))", "(1.*2*3)", "(2.2*(4-2)"};
    public static String complex_form1 = "(" + good_forms[3] + "*" + good_forms[4] + ")";
    public static String complex_form2 = "(" + good_forms[2] + "*" + complex_form1 + ")";

    public static void main(String[] a) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        System.out.println("**** Test1 ****");
        FormCalculator.setDEBUG_mode(false);
        System.out.println("Good Examples - should be all true");
        for (int i = 0; i < good_forms.length; i++) {
            boolean isForm = FormCalculator.isForm(good_forms[i]);
            System.out.println(i + ") " + good_forms[i] + "  isForm: " + isForm);
        }
        System.out.println("Bad Examples - should be all false");
        for (int i = 0; i < bad_forms.length; i++) {
            boolean isForm = FormCalculator.isForm(bad_forms[i]);
            System.out.println(i + ") " + bad_forms[i] + "  isForm: " + isForm);
        }
    }

    public static void test2() {
        System.out.println();
        System.out.println("**** Test2 ****");
        FormCalculator.setDEBUG_mode(true);
        System.out.println("Good (yet complicated) example - should be true");
        boolean isForm = FormCalculator.isForm(complex_form1);
        System.out.println(complex_form1 + " isForm: " + isForm);
    }

    public static void test3() {
        System.out.println();
        System.out.println("**** Test3 ****");
        FormCalculator.setDEBUG_mode(true);

        System.out.println("Good (yet complicated) example - should be return value 45  = (1.5*(6*(2.5*(4-2))))");
        Double d = FormCalculator.formValue(complex_form2);
        System.out.println(complex_form2 + " formValue = " + d);
    }
}
