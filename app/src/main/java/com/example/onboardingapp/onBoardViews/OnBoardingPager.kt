package com.example.onboardingapp.onBoardViews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onboardingapp.data.PageData
import com.example.onboardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item:List<PageData>,
    pagerState: PagerState,
    modifier: Modifier =Modifier,
    navController: NavController,
    store: StoreBoarding
){
    Box(modifier=Modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            HorizontalPager(state=pagerState){
                //Se Agregan los 3 elementos, imagen, titulo y descripcion
                page->
                Column(
                    modifier=Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    LoaderData(modifier=Modifier
                        .size(200.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                        item[page].imagen
                    )
                    Text(
                        text=item[page].titulo,
                        modifier=Modifier.padding(top=50.dp),
                        color= Color.Black,
                        style= MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text=item[page].descripcion,
                        color= Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize=20.sp
                    )
                }
            }
            PagerIndicator(item.size,pagerState.currentPage)
        }
        Box(modifier=Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(pagerState.currentPage,navController,store)
        }
    }

}

