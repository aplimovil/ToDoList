
public class MainActivity extends AppCompatActivity {


    /************************ Add this code *************************/

    private void addQR() {
        addingNew = true;
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();

    }

    /************************ Add this code *************************/

}