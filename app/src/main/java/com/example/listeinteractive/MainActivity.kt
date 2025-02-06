import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color

data class Pays(val nom: String, val description: String)

@Composable
fun PaysList(paysList: List<Pays>) {
    var selectedPays by remember { mutableStateOf<Pays?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        paysList.forEach { pays ->
            Text(
                text = pays.nom,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedPays = pays }
                    .padding(8.dp)
            )
        }
        selectedPays?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val paysList = listOf(
                Pays("Angleterre", "Berceau de Shakespeare et du thé de l'après-midi, l'Angleterre est riche en histoire et en culture."),
                Pays("Corée", "Divisée en deux nations distinctes, la Corée du Sud est connue pour sa technologie avancée et sa culture pop, tandis que la Corée du Nord est plus isolée."),
                Pays("RDC", "Un pays d'Afrique centrale, riche en ressources naturelles et biodiversité, mais marqué par des défis politiques et sociaux."),
                Pays("USA", "Une superpuissance mondiale, célèbre pour sa diversité culturelle, ses innovations technologiques et son influence économique."),
                Pays("France", "Réputée pour sa cuisine, son art et son histoire, la France est un centre culturel et touristique majeur."),
                Pays("Belgique", "Connue pour ses chocolats, ses gaufres et ses institutions européennes, la Belgique est un pays multilingue et multiculturel."),
                Pays("Japon", "Un mélange fascinant de traditions anciennes et de modernité, le Japon est célèbre pour sa technologie, sa cuisine et ses paysages."),
                Pays("Maroc", "Un pays d'Afrique du Nord, riche en histoire et en culture, avec des paysages allant des montagnes de l'Atlas aux dunes du Sahara."),
                Pays("Tanzanie", "Abritant le mont Kilimandjaro et le parc national du Serengeti, la Tanzanie est un joyau de la biodiversité africaine.")
            )
            PaysList(paysList)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val paysList = listOf(
        Pays("Angleterre", "Berceau de Shakespeare et du thé de l'après-midi, l'Angleterre est riche en histoire et en culture."),
        Pays("Corée", "Divisée en deux nations distinctes, la Corée du Sud est connue pour sa technologie avancée et sa culture pop, tandis que la Corée du Nord est plus isolée."),
        Pays("RDC", "Un pays d'Afrique centrale, riche en ressources naturelles et biodiversité, mais marqué par des défis politiques et sociaux."),
        Pays("USA", "Une superpuissance mondiale, célèbre pour sa diversité culturelle, ses innovations technologiques et son influence économique."),
        Pays("France", "Réputée pour sa cuisine, son art et son histoire, la France est un centre culturel et touristique majeur."),
        Pays("Belgique", "Connue pour ses chocolats, ses gaufres et ses institutions européennes, la Belgique est un pays multilingue et multiculturel."),
        Pays("Japon", "Un mélange fascinant de traditions anciennes et de modernité, le Japon est célèbre pour sa technologie, sa cuisine et ses paysages."),
        Pays("Maroc", "Un pays d'Afrique du Nord, riche en histoire et en culture, avec des paysages allant des montagnes de l'Atlas aux dunes du Sahara."),
        Pays("Tanzanie", "Abritant le mont Kilimandjaro et le parc national du Serengeti, la Tanzanie est un joyau de la biodiversité africaine.")
    )
    PaysList(paysList)
}
