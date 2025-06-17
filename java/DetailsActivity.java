package com.example.final_project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView title, ticketId, tagMaintenance, tagPending, submittedInfo,
            userInfo, locationValue, descValue, timeline1, timeline2;
    ImageView attachmentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details); // Make sure this matches your XML file name

        // Linking all views from XML
        title = findViewById(R.id.title);
        ticketId = findViewById(R.id.ticket_id);
        tagMaintenance = findViewById(R.id.tag_maintenance);
        tagPending = findViewById(R.id.tag_pending);
        submittedInfo = findViewById(R.id.submitted_info);
        userInfo = findViewById(R.id.user_info);
        locationValue = findViewById(R.id.location_value);
        descValue = findViewById(R.id.desc_value);
        attachmentImage = findViewById(R.id.attachment_image);
        timeline1 = findViewById(R.id.timeline1);
        timeline2 = findViewById(R.id.timeline2);

        // You can set dynamic content here if needed in future.
        // For now, it uses static data from XML.

        // Example: setting title dynamically
        // title.setText("Broken Fan in Library");
    }
}
