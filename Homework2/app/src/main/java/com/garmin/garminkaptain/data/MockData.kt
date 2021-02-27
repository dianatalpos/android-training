package com.garmin.garminkaptain.data


val poiList: List<PointOfInterest> = listOf(
    PointOfInterest(
        46067,
        MapLocation(37.8180564724432, -122.52704143524173),
        "Point Bonita",
        "Anchorage",
        ReviewSummary(3.0, 1),
    ),
    PointOfInterest(
        12975,
        MapLocation(37.8770892291283, -122.503309249878),
        "Richardson Bay Marina",
        "Marina",
        ReviewSummary(5.0, 1),
    ),
    PointOfInterest(
        46085,
        MapLocation(37.82878469060811, -122.47633210712522),
        "Needles",
        "Anchorage",
        ReviewSummary(1.0, 2),
    ),
    PointOfInterest(
        19637,
        MapLocation(37.82077, -122.4786),
        "Golden Gate Bridge",
        "Bridge",
        ReviewSummary(0.0, 0),
    ),
    PointOfInterest(
        60928,
        MapLocation(37.8325155338083, -122.47500389814363),
        "Horseshoe Cove",
        "Anchorage",
        ReviewSummary(3.0, 2),
    ),
    PointOfInterest(
        39252,
        MapLocation(37.833886767314, -122.475371360779),
        "Presidio Yacht Club",
        "Marina",
        ReviewSummary(3.0, 5),
    ),
    PointOfInterest(
        25644,
        MapLocation(37.8673327691044, -122.435932159424),
        "Ayala Cove",
        "Anchorage",
        ReviewSummary(4.7, 18),
    ),
    PointOfInterest(
        61865,
        MapLocation(37.850002964208095, -122.41632213957898),
        "Tide Rips",
        "Hazard",
        ReviewSummary(0.0, 0),
    ),
    PointOfInterest(
        46713,
        MapLocation(37.827799573006274, -122.42648773017541),
        "Dangerous Rock",
        "Hazard",
        ReviewSummary(0.0, 0),
    ),
    PointOfInterest(
        57109,
        MapLocation(37.87572310328571, -122.50570595169079),
        "Woodrum Marine Boat Repair/Carpentry",
        "Business",
        ReviewSummary(0.0, 0),
    )
)

val reviews: List<Review> = listOf(
    Review(
        1,
        46067,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        2,
        46067,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Nicole",
        "2020\\01\\10"
    ),
    Review(
        3,
        57109,
        3.9,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Sophie",
        "2018\\07\\20"
    ),
    Review(
        4,
        57109,
        4.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Elisabeth",
        "2021\\01\\10"
    ),
    Review(
        5,
        46713,
        4.7,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Rose",
        "2020\\02\\05"
    ),
    Review(
        6,
        46713,
        2.8,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2019\\12\\23"
    ),
    Review(
        7,
        61865,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Jack",
        "2020\\01\\10"
    ),
    Review(
        8,
        61865,
        5.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2019\\09\\16"
    ),
    Review(
        9,
        25644,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        10,
        25644,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        11,
        39252,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        12,
        39252,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        13,
        60928,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        14,
        60928,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Tom",
        "2020\\01\\10"
    ),
    Review(
        15,
        19637,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\10"
    ),
    Review(
        16,
        19637,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Ryan",
        "2020\\11\\12"
    ),
    Review(
        17,
        46085,
        3.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\20"
    ),
    Review(
        18,
        46085,
        2.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Marie",
        "2020\\01\\15"
    ),
    Review(
        19,
        12975,
        2.5,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Anna",
        "2020\\01\\15"
    ),
    Review(
        20,
        12975,
        1.0,
        "Awesome!",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Phasellus ornare sem eu sem accumsan pellentesque." +
                " Curabitur ex metus, rhoncus non ullamcorper sit amet, scelerisque ut purus." +
                " Ut et elit vel massa finibus ornare. Etiam ut metus in magna vulputate egestas. " +
                "Fusce nec dui vitae arcu varius ullamcorper. Nam et elementum nunc.",
        "Andrew",
        "2020\\10\\10"

    )
)

