package com.dfc.ezekiel.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dfc.ezekiel.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(
                        headerImage = painterResource(id = R.drawable.bg_compose_background),
                        title=stringResource(id = R.string.headerArticle),
                        stringResource(id = R.string.firstParagraph),
                        stringResource(id = R.string.secondParagraph),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleHeader(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FirstParagraph(firstParagraph:String, modifier: Modifier = Modifier){
    Text(
        text = firstParagraph,
        fontSize = 12.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp, 16.dp)
    )
}

@Composable
fun SecondParagraph(secondParagraph: String, modifier: Modifier = Modifier){
    Text(
        text = secondParagraph,
        fontSize = 12.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Article(headerImage: Painter, title:String, firstParagraph:String, secondParagraph: String, modifier: Modifier = Modifier){
    Column(modifier) {
        Image(
            painter = headerImage,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(0.dp,40.dp, 0.dp)
        )
        ArticleHeader(title)
        FirstParagraph(firstParagraph)
        SecondParagraph(secondParagraph)
    }
}

@Preview(showBackground = true, name = "Article")
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(
            painterResource(id = R.drawable.bg_compose_background),
            stringResource(id = R.string.headerArticle),
            stringResource(id = R.string.firstParagraph),
            stringResource(id = R.string.secondParagraph)
        )
    }
}