import java.io.File;
// import java.io.FileInputStream;
import java.io.FileNotFoundException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.Arrays;
import java.util.Scanner;

public class BCKEND {
    double x[][], y[];
    String msg, content;
    double[][] data;
    double predictions[];
    int intervallength, forecasts;
    LinearRegression lrlist[];

    BCKEND(String filename, int forecasts, int intervallength) throws FileNotFoundException {
        predictions = new double[intervallength];
        data = new double[intervallength][forecasts];
        this.intervallength = intervallength;
        this.forecasts = forecasts;
        Scanner sc = new Scanner(
                new File("C:\\Users\\akshi\\Desktop\\klu\\java\\java_PROJECT\\miniproject\\src\\a.csv"));
        sc.useDelimiter(","); // String [] values ;
        double[] dValues = new double[forecasts * intervallength];
        int i = 0;
        int k = 0;
        while (sc.hasNext()) {
            double value = Double.valueOf(sc.next());
            dValues[i++] = value;
        }
        sc.close();
        for (double d : dValues) {
            System.out.printf(" %3.2f", d);
        }
        ;
        i = 0;
        while (i < dValues.length) {
            for (int j = 0; j < intervallength; j++) {
                data[j][k] = dValues[i++];
            }
            k++;
        }
        displayData();
        this.applyRegressors();
        for (int j = 0; j < intervallength; j++) {
            predictions[j] = lrlist[j].predict(data[j][forecasts - 1]);
        }
        for (double d : predictions) {
            System.out.printf(" %3.2f", d);
        }
        ;
    }

    void displayData() {
        for (double[] d : data) {
            for (double v : d) {
                System.out.println(v + " ");
            }
            System.out.println();
        }
    }

    void applyRegressors() {
        lrlist = new LinearRegression[intervallength];
        int i = 0;
        double[] x = new double[forecasts - 1], y = new double[forecasts - 1];
        ;
        for (int a = 0; a < intervallength; a++) {
            for (int j = 0; j < forecasts - 1; j++) {
                x[j] = data[i][j];
            }
            for (int j = 1, k = 0; j < forecasts; j++, k++) {
                y[k] = data[i][j];
            }
            lrlist[a] = new LinearRegression(x, y);
            i++;
            System.out.println(lrlist[a].toString());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        double x[] = { 2, 4, 6, 8, 10, 12 };
        double y[] = { 1, 2, 3, 4, 5, 6 };
        LinearRegression lr = new LinearRegression(x, y);
        System.out.println(lr.toString());
        new BCKEND("C:\\Users\\akshi\\Desktop\\klu\\java\\java_PROJECT\\miniproject\\src\\a.csv", 4, 4);
    }
}

// File csvFile = new File(filename);msg="in processing file";FileInputStream f;
// try{f = new FileInputStream(filename);int n = f.available();
// for (int i = 0; i < n; i++) {
// content += (char) f.read();}
// // fileNameP = Path.of("demo.txt");
// // content=Files.readString(fileNameP);
// }
// catch(Exception e){msg = "invalid file or file location";}

// double [] dValues =
// Arrays.stream(values).mapToDouble(Double::parseDouble).toArray();
