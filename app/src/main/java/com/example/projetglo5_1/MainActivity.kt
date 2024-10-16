package com.example.projetglo5_1

import android.graphics.Paint
import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projetglo5_1.ui.theme.ProjetGlo5_1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ArtGallery()

        }
    }
}
//ici nous definissons la structure d'un element de la galiere
data class Tableau(val titre: String, val description: String, val source: Int)
//ici la liste des element de la galerie
var Galerie= arrayListOf<Tableau>(
    Tableau(titre = "Tableau1", description = "nous vous presentons le premier tableau", source = R.drawable.art_2),
    Tableau(titre = "Tableau2", description = "nous vous presentons le deuxieme tableau", source = R.drawable.art_2),
    Tableau(titre = "Tableau3", description = "nous vous presentons le troisieme tableau", source = R.drawable.art_3),
    Tableau(titre = "Tableau4", description = "nous vous presentons le quatrieme tableau", source = R.drawable.art_2),
    Tableau(titre = "Tableau5", description = "nous vous presentons le cinquieme tableau", source = R.drawable.art_5 )
)

@Composable
public fun ArtGalerryTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
): Unit{}

@Composable
 fun Spacer(modifier: Modifier=Modifier.height(16.dp)){
        Box(modifier = Modifier.height(20.dp))
 }


@Composable
 fun AffichageGallerie(modifier: Modifier=Modifier .fillMaxSize()){
    var result by remember { mutableStateOf(3) }
    val configuration = LocalConfiguration.current
    val screenwidth=configuration.screenWidthDp
    var screenHeight=configuration.screenHeightDp
    val imageRessource:Int = when(result){
        1-> Galerie[0].source
        2-> Galerie[1].source
        3->Galerie[2].source
        4-> Galerie[3].source
        else -> Galerie[4].source
    }
    val titreRessource :String= when(result){
        1-> Galerie[0].titre
        2-> Galerie[1].titre
        3->Galerie[2].titre
        4-> Galerie[3].titre
        else -> Galerie[4].titre
    }
    val descriptionRessource :String = when(result){
        1-> Galerie[0].description
        2-> Galerie[1].description
        3->Galerie[2].description
        4-> Galerie[3].description
        else -> Galerie[4].description
    }
        Column(modifier=Modifier
            .padding(all = 10.dp)
            .fillMaxSize()
            .offset(y = 50.dp)
            , horizontalAlignment = Alignment.CenterHorizontally)
        {

                Box(modifier= Modifier
                    .width((screenwidth*80/100).dp)
                    .height((screenHeight*50/100).dp)
                    .shadow(
                        elevation = 5.dp,
                        clip = true,
                        ambientColor = colorResource(R.color.D3C8C8),

                        )
                    .background(color = colorResource(R.color.white))
                    ,
                    contentAlignment = Alignment.Center
                ){

                    Image(painter = painterResource(imageRessource), contentDescription ="1", modifier = Modifier
                        .width((screenwidth*80/100).dp)
                        .height((screenHeight*49/100).dp))
                }
                Spacer( modifier=Modifier.height(30.dp) .offset(y = 60.dp))
                Box(modifier= Modifier
                    .width((screenwidth*80/100).dp)
                    .height(80.dp)
                    .background(color = colorResource(R.color.D3C8C8), shape = RectangleShape)
                    .border(width = 8.dp, color = colorResource(R.color.D3C8C8))
                    , contentAlignment = Alignment.Center   )

                {
                    Text(text ="description :"+ descriptionRessource, fontSize = 10.sp, fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 5, modifier = Modifier.padding(8.dp))
                }
            Row (modifier=Modifier .offset(y = (screenHeight*15/100).dp) ){

                Button(onClick = {
                                    if (result==0){
                                        result=4
                                    }else{
                                        result--
                                    }
                                 } ,modifier=Modifier
                    .padding(end = (screenwidth*15/100).dp)        ) {
                    Text(stringResource(R.string.precedent))
                }
                Button(onClick = {
                    if (result==4){
                        result=0
                    }else{
                        result++
                    }
                                 },modifier=Modifier
                        .padding(start = (screenwidth*15/100).dp)        ) {
                    Text(stringResource(R.string.suivant))
                }
            }


        }
 }


@Preview(showBackground = true)
@Composable
fun ArtGallery(){
    AffichageGallerie()
}
