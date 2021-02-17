package com.garmin.garminkaptain.data

import java.util.*

data class PointOfInterest(
    val id: Long,
    val mapLocation: MapLocation,
    val name: String,
    val poiType: String,
    val reviewSummary: ReviewSummary,
    val reviews: List<Review>
)

data class MapLocation(
    val latitude: Double,
    val longitude: Double
)

data class ReviewSummary(
    val averageRating: Double,
    val numberOfReviews: Int
)

data class Review(
    val id: Long,
    val rating: Double,
    val title: String,
    val text: String,
    val user: String,
    val date: Date
)

val poiList: List<PointOfInterest> = listOf(
    PointOfInterest(
        46067,
        MapLocation(37.8180564724432, -122.52704143524173),
        "Point Bonita",
        "Anchorage",
        ReviewSummary(3.0, 1),
        listOf(
            Review(
                1,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                2,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Nicole",
                GregorianCalendar(2020, 1, 10).time
            )
        )

    ),
    PointOfInterest(
        12975,
        MapLocation(37.8770892291283, -122.503309249878),
        "Richardson Bay Marina",
        "Marina",
        ReviewSummary(5.0, 1),
        listOf(
            Review(
                11,
                2.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                12,
                1.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Andrew",
                GregorianCalendar(2020, 10, 10).time
            )
        )
    ),
    PointOfInterest(
        46085,
        MapLocation(37.82878469060811, -122.47633210712522),
        "Needles",
        "Anchorage",
        ReviewSummary(1.0, 2),
        listOf(
            Review(
                21,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 20).time
            ),
            Review(
                22,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Marie",
                GregorianCalendar(2020, 1, 15).time
            )
        )
    ),
    PointOfInterest(
        19637,
        MapLocation(37.82077, -122.4786),
        "Golden Gate Bridge",
        "Bridge",
        ReviewSummary(0.0, 0),
        listOf(
            Review(
                31,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                32,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Ryan",
                GregorianCalendar(2020, 11, 12).time
            )
        )
    ),
    PointOfInterest(
        60928,
        MapLocation(37.8325155338083, -122.47500389814363),
        "Horseshoe Cove",
        "Anchorage",
        ReviewSummary(3.0, 2),
        listOf(
            Review(
                1,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                2,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Tom",
                GregorianCalendar(2020, 1, 10).time
            )
        )
    ),
    PointOfInterest(
        39252,
        MapLocation(37.833886767314, -122.475371360779),
        "Presidio Yacht Club",
        "Marina",
        ReviewSummary(3.0, 5),
        listOf(
            Review(
                1,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                2,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            )
        )
    ),
    PointOfInterest(
        25644,
        MapLocation(37.8673327691044, -122.435932159424),
        "Ayala Cove",
        "Anchorage",
        ReviewSummary(4.7, 18),
        listOf(
            Review(
                1,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                2,
                2.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2020, 1, 10).time
            )
        )
    ),
    PointOfInterest(
        61865,
        MapLocation(37.850002964208095, -122.41632213957898),
        "Tide Rips",
        "Hazard",
        ReviewSummary(0.0, 0),
        listOf(
            Review(
                1,
                3.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Jack",
                GregorianCalendar(2020, 1, 10).time
            ),
            Review(
                2,
                5.0,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2019, 9, 16).time
            )
        )
    ),
    PointOfInterest(
        46713,
        MapLocation(37.827799573006274, -122.42648773017541),
        "Dangerous Rock",
        "Hazard",
        ReviewSummary(0.0, 0),
        listOf(
            Review(
                1,
                4.7,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Rose",
                GregorianCalendar(2020, 2, 5).time
            ),
            Review(
                2,
                2.8,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Anna",
                GregorianCalendar(2019, 12, 23).time
            )
        )
    ),
    PointOfInterest(
        57109,
        MapLocation(37.87572310328571, -122.50570595169079),
        "Woodrum Marine Boat Repair/Carpentry",
        "Business",
        ReviewSummary(0.0, 0),
        listOf(
            Review(
                1,
                3.9,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Sophie",
                GregorianCalendar(2018, 7, 20).time
            ),
            Review(
                2,
                4.5,
                "Awesome!",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Phasellus ornare sem eu sem accumsan pellentesque." +
                        " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                        " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                        "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
                "Elisabeth",
                GregorianCalendar(2021, 1, 10).time
            )
        )
    )
)