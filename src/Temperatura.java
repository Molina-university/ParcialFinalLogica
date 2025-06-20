public class Temperatura {

    public static void TemperaturasMuyAltas(int[][] ciudades) {
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                if (ciudades[i][j] > 38) {
                    System.out.println("Temperatura muy alta ubicada en [" + i + "][" + j + "]: " + ciudades[i][j] + " grados (si sufre de golpes de calor mejor vaya para Bogota)");
                    System.out.println("------------------------------------------------------------------------------------------------------");
                }
                
                if (ciudades[i][j] <= 10) {
                    System.out.println("Temperatura muy baja ubicada en [" + i + "][" + j + "]: " + ciudades[i][j] + " grados (Nojoa papi pero no era tan literal)");
                    System.out.println("-------------------------------------------------------------------------------------");
                }
            }
        }
    }
    public static int DiasCalurosos(int[][] ciudades) {
        int contadorDiasCalurosos = 0;
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                if (ciudades[i][j] > 30) {
                    contadorDiasCalurosos++;
                }
            }
        }
        return contadorDiasCalurosos;
    }
    public static int[] CiudadMasCaliente(int[][] ciudades) {
        int maxTemp = Integer.MIN_VALUE;
        int[] Ubicacion = new int[2]; 

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                if (ciudades[i][j] > maxTemp) {
                    maxTemp = ciudades[i][j];
                    Ubicacion[0] = i;
                    Ubicacion[1] = j;
                }
            }
        }
        return Ubicacion;
    }

    public static double promedioDiasFrescos(int[][] ciudades) {
        int suma = 0, contadorDiasFrescos = 0;
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                if (ciudades[i][j] < 20) {
                    suma += ciudades[i][j];
                    contadorDiasFrescos++;
                }
            }
        }
        return contadorDiasFrescos > 0 ? (double) suma / contadorDiasFrescos : 0;
    }
    // aca voy a mostrar las temperaturas de las ciudades para que sepan como estan las temperaturas en consola
    public static void mostrarTemperaturas(int[][] ciudades) {
        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < ciudades[i].length; j++) {
                System.out.print(ciudades[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] temperaturas = {
            {45, 15, 25, 35, 30},
            {40, 35, 31, 7, 38},
            {7, 2, 8, 15, 5},
            {37, 36, 15, 35, 35}
        };
        TemperaturasMuyAltas(temperaturas);
        int[] MayorTemperatura = CiudadMasCaliente(temperaturas);
        
        System.out.println("ciudades con temperatura mayor a 30°: [ " + DiasCalurosos(temperaturas) + " ], se recomienda llevar una barra de hielo porque con esas calores hasta las llantas se derriten :v");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Promedio de temperaturas de ciudades menores a 20°: " + promedioDiasFrescos(temperaturas));
        System.out.println("---------------------------------------------------------");
        System.out.println("la ciudad con la mayor temperatura registrada se encuentra en la posición: [" + MayorTemperatura[0] + "][" + MayorTemperatura[1] + "]");
        System.out.println("---------------------------------------------------------------------------------");
    }
}