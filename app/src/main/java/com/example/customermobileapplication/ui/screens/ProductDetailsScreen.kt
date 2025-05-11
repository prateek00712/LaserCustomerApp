package com.example.customermobileapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.customermobileapplication.AppColors
import com.example.customermobileapplication.R
import com.example.customermobileapplication.data.ProductDetail
import com.example.customermobileapplication.data.api.data.Product
import com.example.customermobileapplication.ui.viewmodel.HomeViewModel

@Composable
fun ProductDetailScreen(product: ProductDetail) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { product.imageResIds.size }
    )
    val expandedSections = remember { mutableStateMapOf<String, Boolean>() }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 72.dp) // Space for fixed Add to Cart button
        ) {
            // Horizontal Image Pager
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                pageSpacing = 0.dp,
                key = { it }
            ) { page ->
                Image(
                    painter = painterResource(id = product.imageResIds[page]),
                    contentDescription = "Product Image",
                    modifier = Modifier.fillMaxSize().background(Color.White),
                    contentScale = ContentScale.Fit,
                )
            }


            // Dot Indicators
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(product.imageResIds.size) { index ->
                    val selected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(if (selected) 10.dp else 6.dp)
                            .clip(CircleShape)
                            .background(if (selected) AppColors.Primary else AppColors.TextSecondary)
                    )
                }
            }

            // Product Info
            Text(
                text = product.name,
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = AppColors.TextPrimary
            )

            Text(
                text = "₹ ${product.price}",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                color = AppColors.Primary
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .height(2.dp),
                color = AppColors.Primary // or use Color(0xFFFF9800)
            )
            // Delivery Info
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = AppColors.Primary)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Free shipping by 14th May • Deliver to Delhi, 110015",
                    fontSize = 14.sp,
                    color = AppColors.TextSecondary,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .height(2.dp),
                color = AppColors.Primary // or use Color(0xFFFF9800)
            )
            Text(
                text = product.shortDescription,
                modifier = Modifier.padding(horizontal = 16.dp),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = AppColors.TextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp)
                    .height(2.dp),
                color = AppColors.Primary // or use Color(0xFFFF9800)
            )
            // Expandable Sections
            val sections = listOf(
                "Product Details" to product.productDetails,
                "Benefits" to product.benefits,
                "How to Use" to product.howToUse,
                "Key Ingredients" to product.contents
            )

            sections.forEach { (title, content) ->
                ExpandableSection(
                    title = title,
                    content = content,
                    isExpanded = expandedSections[title] == true,
                    onToggle = {
                        expandedSections[title] = !(expandedSections[title] ?: false)
                    }
                )

            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Add to Cart Button - Fixed to bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Button(
                onClick = { /* Add to cart logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AppColors.Primary)
            ) {
                Text(
                    text = "Add to cart",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun ExpandableSection(
    title: String,
    content: String,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onToggle() }
        ) {
            Text(
                text = title.replaceFirstChar { it.uppercase() },
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 16.sp,
                color = AppColors.TextPrimary,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                tint = AppColors.Primary
            )
        }
        if (isExpanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                fontSize = 14.sp,
                color = AppColors.TextSecondary,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}


@Composable
fun StaticProductDetailScreenPreviewSerum() {
    val dummyProduct = ProductDetail(
        name = "Agelite-X Serum",
        price = 999,
        imageResIds = listOf(
            R.drawable.ic_face_serum
        ),
        shortDescription = "Agelite-X Serum is specially concocted with antioxidants that provide synergistic protection against oxidative stress in the skin. It works to brighten dull skin, improve hyperpigmentation, sun/photo-damaged skin, fine lines, and wrinkles.",
        productDetails = "Vitamin C20 Serum contains a highly stable form of vitamin C, i.e., Ethyl Ascorbic Acid, that defends against environmental stressors and improves uneven skin tone for a radiant glow.\n" +
                "\n" +
                "Suitable for Normal, Oily & Dry Skin.\n" +
                "Available as: 15ml / 0.5 fl.oz.",
        benefits = "Brightens dull skin and enhances natural glow.\n" +
                "Improves hyperpigmentation and evens skin tone.\n" +
                "Fights signs of aging like fine lines and wrinkles.\n" +
                "Offers protection against environmental and oxidative stress.\n" +
                "Contains a stable and effective form of Vitamin C.",
        howToUse = "Step 1: Cleanse your face thoroughly and pat dry.\n" +
                "Step 2: Apply 2-3 drops of Agelite-X Serum to your face and neck.\n" +
                "Step 3: Gently massage until fully absorbed.\n" +
                "Step 4: Follow up with a moisturizer and sunscreen if used in the daytime.\n" +
                "Use daily for best results, preferably in the morning.",
        contents = "Purified Water\n" +
                "Ethyl Ascorbic Acid\n" +
                "Ethoxydiglycol\n" +
                "Dimethyl Isosorbide\n" +
                "Propanediol\n" +
                "Ferulic Acid\n" +
                "Xanthan Gum\n" +
                "Sodium Hyaluronate\n" +
                "DMDM Hydantoin (and) Iodopropynyl Butylcarbamate\n" +
                "Vitamin E Acetate\n" +
                "Suitable Base\n" +
                "Perfume"
    )

    ProductDetailScreen(product = dummyProduct)
}

@Composable
fun StaticProductDetailScreenPreviewFaceWash() {
    val dummyProduct = ProductDetail(
        name = "Agelite Vitamin C Face Wash",
        price = 999,
        imageResIds = listOf(
            R.drawable.ic_face_wash_3,
            R.drawable.ic_face_wash_2,
            R.drawable.ic_face_wash_4,
            R.drawable.ic_face_wash_img,

        ),
        shortDescription = "Agelite Vitamin C Face Wash is designed to cleanse and brighten your skin, harnessing the powerful benefits of Vitamin C. This face wash effectively removes impurities, excess oil, and makeup while promoting a radiant complexion. Enriched with antioxidants, it helps to rejuvenate and protect the skin from environmental damage. Suitable for daily use, Agelite Vitamin C Face Wash leaves your skin feeling fresh, smooth, and glowing.",
        productDetails = "Agelite Vitamin C Face Wash is designed to cleanse and brighten your skin, harnessing the powerful benefits of Vitamin C. This face wash effectively removes impurities, excess oil, and makeup while promoting a radiant complexion. Enriched with antioxidants, it helps to rejuvenate and protect the skin from environmental damage. Suitable for daily use, Agelite Vitamin C Face Wash leaves your skin feeling fresh, smooth, and glowing.\n" +
                "Agelite Vitamin C Face Wash is suitable for all skin types, including oily, dry, and combination skin. Its gentle formula makes it ideal for daily use without over-drying the skin.\n" +
                "\n" +
                "To achieve best results, use twice daily—morning and evening—as part of your regular skincare routine. Follow with a toner and moisturizer for enhanced hydration and protection.\n" +
                "\n" +
                "Store in a cool, dry place and avoid direct sunlight. For external use only.",
        benefits = "Cleanses and brightens the skin.\n" +
                "Removes impurities, excess oil, and makeup.\n" +
                "Enriched with Vitamin C and antioxidants.\n" +
                "Rejuvenates and protects the skin.\n" +
                "Suitable for daily use.",
        howToUse = "Step 1: Apply a small amount to wet skin.\n" +
                "Step 2: Gently massage in circular motions, avoiding the eye area.\n" +
                "Step 3: Rinse thoroughly with water and pat dry.",
        contents = "Vitamin C\n" +
                "Glycerin\n" +
                "Aloe Vera Extract\n" +
                "Citric Acid\n" +
                "Antioxidants"
    )

    ProductDetailScreen(product = dummyProduct)
}

@Composable
fun StaticProductDetailScreenPreviewMoisturizer() {
    val dummyProduct = ProductDetail(
        name = "Relizema Ultra Hydrating Lotion",
        price = 655,
        imageResIds = listOf(
            R.drawable.ic_moisturizer_img,
            R.drawable.ic_moisturizer_2,

            ),
        shortDescription = "Relizema Ultra Hydrating Lotion is a revitalizing skincare product designed to restore your skin's natural barrier. Specially crafted for sensitive and dry skin, it boosts hydration and elasticity while providing long-lasting moisture and protection. Perfect for daily use, it nourishes and protects your skin from dryness and environmental stressors.",
        productDetails = "Relizema Ultra Hydrating Lotion is a great choice for those seeking to boost their skin's hydration levels and protect it from dryness and environmental stress. Its gentle formula is ideal for sensitive skin types and ensures that your skin remains moisturized and supple throughout the day.",
        benefits = "Replenishes the skin's natural protective barrier.\n" +
                "Increases moisture levels for a healthy glow.\n" +
                "Boosts skin's suppleness and elasticity.\n" +
                "Offers protection and nourishment for sensitive and dry skin.\n" +
                "Keeps skin hydrated throughout the day.",
        howToUse = "Step 1: After cleansing, pump the lotion dispenser once or twice.\n" +
                "Step 2: Apply a small amount onto your hands and massage gently into the skin.\n" +
                "Step 3: Ensure the lotion is fully absorbed for smooth, hydrated skin.",
        contents = "Butyrrospermum Parkii Butter\n" +
                "Glycerin\n" +
                "Prunus Amygdalus Dulcis Oil\n" +
                "Linum Usitatissimum Seed Oil\n" +
                "Olea Europaea Fruit Oil\n" +
                "Borago Officinalis Seed Oil\n" +
                "Tocopherol"
    )

    ProductDetailScreen(product = dummyProduct)
}

@Composable
fun StaticProductDetailScreenPreviewPigmentation() {
    val dummyProduct = ProductDetail(
        name = "Melalumin Ultra Depigmenting Cream",
        price = 499,
        imageResIds = listOf(
            R.drawable.ic_pigemntation_img,
            R.drawable.ic_pigmentation_2,
            R.drawable.ic_pigmentation_3,

            ),
        shortDescription = "Melalumin Ultra Depigmenting Cream is a depigmenting and skin-lightening cream formulated to treat skin hyperpigmentation and reduce the appearance of dark spots. It helps promote skin vitality and even out the skin tone.",
        productDetails = "Melalumin Ultra Depigmenting Cream is ideal for treating various forms of skin pigmentation, including sun damage, melasma, and post-inflammatory pigmentation. Suitable for all skin types, it works effectively when used regularly.",
        benefits = "The cream targets excess melanin production, helping to reduce dark spots, melasma, and other forms of hyperpigmentation.\n" +
                "It promotes an even skin tone and helps fade dark spots and discoloration.\n" +
                "Contains nourishing ingredients that improve the overall health and vitality of the skin.\n" +
                "Effective for various pigmentation issues caused by sun damage, hormonal imbalances, or post-inflammatory hyperpigmentation.\n",
        howToUse = "Step 1: Apply twice daily on the face after washing.\n" +
                "Step 2: Gently massage the cream onto the face until absorbed.\n" +
                "Step 3: Use consistently for visible results.",
        contents = "Niacinamide - 4%\n" +
                "Glycolic Acid - 3%\n" +
                "Kojic Acid - 2%\n" +
                "Arbutin - 2%\n" +
                "Alpha Melight - 1%\n" +
                "Cosmevit DCX - 1%\n" +
                "Microfine Ti02 - 0.5%"
    )

    ProductDetailScreen(product = dummyProduct)
}

@Composable
fun StaticProductDetailScreenPreviewOxidant() {
    val dummyProduct = ProductDetail(
        name = "Skinjoy-GL Fizz Effervescent Tablet",
        price = 999,
        imageResIds = listOf(
            R.drawable.ic_skin_antioxi_img

            ),
        shortDescription = "Skinjoy-GL Fizz Effervescent Tablet is an effective nutritional supplement used to manage and treat various medical conditions resulting from nutritional deficiencies and long-term disorders. It is also beneficial in treating skin problems such as freckles, melasma (chloasma), and lentigo. The combination of L Glutathione and Vitamin C helps to improve skin health, detoxify the body, and promote a youthful and radiant complexion. Glutathione is known for its detoxification properties, while Vitamin C contributes to maintaining healthy skin and boosting immunity.",
        productDetails = "Skinjoy-GL Fizz Effervescent Tablet is an effective nutritional supplement used to manage and treat various medical conditions resulting from nutritional deficiencies and long-term disorders. It is also beneficial in treating skin problems such as freckles, melasma (chloasma), and lentigo. The combination of L Glutathione and Vitamin C helps to improve skin health, detoxify the body, and promote a youthful and radiant complexion. Glutathione is known for its detoxification properties, while Vitamin C contributes to maintaining healthy skin and boosting immunity.Skinjoy-GL Fizz Effervescent Tablet helps improve skin health, enhances the immune system, and reduces the appearance of skin imperfections like freckles and melasma. It is recommended for individuals experiencing nutritional deficiencies or those with skin concerns that require effective treatment.\n" +
                "\n" +
                "Consult your doctor before using this supplement, especially if you have pre-existing conditions or are pregnant or breastfeeding.",
        benefits = "Improves skin tone and texture, reducing freckles, melasma, and lentigo.\n" +
                "Supports immune health and detoxifies the body through Glutathione.\n" +
                "Promotes collagen production for firmer, youthful skin.\n" +
                "Contains Vitamin C to enhance skin health and protect against oxidative damage.",
        howToUse = "Step 1: Shake the bottle well before each use.\n" +
                "Step 2: Take the suggested dose as directed by your healthcare practitioner, using the provided measuring cup, dosing syringe, or dropper.\n" +
                "Step 3: Follow the dosage instructions carefully, and do not exceed the recommended dose.",
        contents = "L Glutathione\n" +
                "Vitamin C (Ascorbic Acid)"
    )

    ProductDetailScreen(product = dummyProduct)
}

@Composable
fun StaticProductDetailScreenPreviewSunscreen() {
    val dummyProduct = ProductDetail(
        name = "Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50",
        price = 2250,
        imageResIds = listOf(
            R.drawable.ic_sunscreen_img,
            R.drawable.ic_sunscreen_2,
            R.drawable.ic_sunscreen_3,
            R.drawable.ic_sunscreen_4,
            R.drawable.ic_sunscreen_5,
        ),
        shortDescription = "Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50 shields your skin from UVA, UVB, blue light, and infrared radiation. It prevents photo-aging, sunburns, and skin imperfections, while serving as an excellent makeup base. Non-comedogenic, water-resistant, and paraben-free, it offers comprehensive protection for radiant, youthful skin.",
        productDetails = "Shield your skin from the harmful effects of UVA and UVB rays with Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50. Lightweight, non-comedogenic, and enriched with skin-friendly ingredients, this sunscreen is designed to blend seamlessly into your skincare routine.\n" +
                "\n" +
                "Perfect for daily wear, it offers high sun protection without leaving a white cast, making it ideal for all skin types, including sensitive and acne-prone skin.\n" +
                "\n" +
                "Make sun safety effortless and effective—choose Dermatica Ray Protect Barelyon Fluid Sunscreen SPF 50 and step out with confidence, knowing your skin is protected and cared for, every day.",
        benefits = "Complete protection against UVA, UVB, blue light, and infrared radiation.\n" +
                "Reduces skin imperfections and dark spots.\n" +
                "Prevents photo-aging, fine lines, and wrinkles.\n" +
                "Provides high-level SPF 50 sunburn protection.\n" +
                "Non-comedogenic, water-resistant, and paraben-free.",
        howToUse = "Take a sufficient amount and apply a thin film on the face, neck, and all exposed areas.\n" +
                "Apply 15 minutes prior to sun exposure.\n" +
                "Reapply after swimming or sweating heavily, or as advised by a physician.",
        contents = "Ethylhexyl Methoxycinnamate\n" +
                "Butyl Methoxydibenzoylmethane\n" +
                "Benzophenone-3\n" +
                "Titanium dioxide\n" +
                "Botanical filters"
    )

    ProductDetailScreen(product = dummyProduct)
}