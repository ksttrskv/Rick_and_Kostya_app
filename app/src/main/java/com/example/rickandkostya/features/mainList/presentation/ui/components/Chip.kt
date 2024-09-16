package com.example.rickandkostya.features.mainList.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Chip() {
    FilterChip(
        selected = true,
        onClick = { /*TODO*/ },
        label = { /*TODO*/ },
        modifier = Modifier.size(6.dp),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.Red,
            selectedContainerColor = Color.Red
        )
    )
}