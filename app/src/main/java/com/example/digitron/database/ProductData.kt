package com.example.digitron.database

import android.content.Context
import com.example.digitron.R

class ProductData(val context: Context){
    private lateinit var iac : HashMap<Int,String>

    val titles = mutableListOf(
        "Accommodation Software","Android App Development","Billing Software","Bulk Email Verifier","Bulk Messenger","Company Lead Extractor",
        "CRM","Custom Software","Custom Web Designing","Digital Business Card","Dynamic Web Designing","Dynamic Website","E-commerce Web Designing","E-commerce Website",
        "E-learning app","E-learning Portal Development","Ecommerce Website Promotion","Educational Software","Email & Phone Web Extractor","Email Marketing",
        "Enterprise Software Solution","Facebook Lead Extractor","Flutter App Development","Google Adwords","Googlemap Lead Extractor","Hospital Management Software",
        "Hybrid App Development","Indiamart Extractor","Iconic App Development","Ios App Development","Just Dial Data Extractor","Linkedin Extractor","LMS Software",
        "MLM Software","Mobile App Maintenance","Mobile Number Lookup","React Native App Development","Real Estate Portal Development","Sales & Purchase Software",
        "SEO Marketing","Social Email Phone Extractor Pro","Social Media Marketing","Static Web Designing","Static Website","Social Media Optimization","TradeIndia Lead Extractor","Transportation Software",
        "Web Portal Development"
    )
    val images = mutableListOf<Int>(
        R.drawable.`as`, R.drawable.aap, R.drawable.billing_software, R.drawable.email_verifier,
        R.drawable.wb, R.drawable.cle, R.drawable.c_r_m, R.drawable.cs,
        R.drawable.cwd, R.drawable.dbc, R.drawable.dwd, R.drawable.dw,
        R.drawable.ewd, R.drawable.ew, R.drawable.elearning, R.drawable.elearning_portal_development,
        R.drawable.ecommerce_website_promotion, R.drawable.es, R.drawable.eapwe, R.drawable.em,
        R.drawable.ess, R.drawable.fle, R.drawable.fad, R.drawable.ga,
        R.drawable.google_maps_lead_extractor, R.drawable.hospital_management_software, R.drawable.had, R.drawable.indiamart,
        R.drawable.iad, R.drawable.iso, R.drawable.justdialextractor, R.drawable.le,
        R.drawable.lms, R.drawable.mlm, R.drawable.mam, R.drawable.mn,
        R.drawable.rnad, R.drawable.rspd, R.drawable.saps, R.drawable.seo,
        R.drawable.smapep, R.drawable.smm, R.drawable.swd, R.drawable.static_website,
        R.drawable.smo, R.drawable.tide, R.drawable.soft, R.drawable.wdp
    )

    val category = mutableListOf<String>(
        "Software","Mobile App Development","Software","Uncategorized",
        "Digital Marketing","Data Extractor","Software","Software",
        "Website Designing","Software","Website Designing","Website",
        "Website Designing","Website","Mobile App","Web Development",
        "Website","Software","Data Extractor","Digital Marketing",
        "Software","Data Extractor","Mobile App Development","Uncategorized",
        "Data Extractor","Software","Mobile App Development","Data Extractor",
        "Mobile App Development","Mobile App Development","Data Extractor","Data Extractor",
        "Software","Software","Mobile","Software",
        "Mobile App Development","Web Development","Software","Digital Marketing",
        "Digital Marketing","Data Extractor","Digital Marketing","Website Designing",
        "Website","Data Extractor","Software","Web Development"
    )

    val description = mutableListOf(
        "A hotel property management system (PMS) is a set of solutions that hoteliers use to manage their day-to-day hotel operations activities such as reservations, front desk, housekeeping, maintenance, billing and invoicing, analytics and reporting.",
        "An Android developer is responsible for developing applications for devices powered by the Android operating system. Due to the fragmentation of this ecosystem, an Android developer must pay special attention to the application’s compatibility with multiple versions of Android and device types.",
        "A billing software can be any software designed to handle time and billing tracking as well as invoicing customers for services and products. It can track the hours worked by employees as well as expenses associated with projects or clients.",
        "Bulk Email Verifier is a tool to verify a list of email addresses. The Email Verifier tests each email address to see if there is a positive reply without sending emails. It also takes into account multiple other verifications such as the format, the type of email addresses, and the eventual public sources online.",
        "Bulk text SMS service allows you to send messages in bulk amounts to several recipients. Hence, it becomes easy for you to educate your customers about the products, services, or offers that you are providing. Plus, the text messages are instantly read as soon as they are delivered.",
        "Extract premium unlimited business/company contacts from the website with no manual effort. It is one of the fastest software available in the market. Company Lead Extractor is a tool that collects contact information such as Company Name, Location, Complete Address, Email, Mobile & WhatsApp Number, Ratings and Reviews, Location co-ordinates, Website URL, and other important information from Website.",
        "CRM (customer relationship management)? Customer relationship management (CRM) is the combination of practices, strategies, and technologies that companies use to manage and analyze customer interactions and data throughout the customer lifecycle.",
        "Custom development refers to the development of software that is distinct and separate from Commercial-Off-The-Shelf (COTS) packaged software or existing packaged open-source software. Custom development either creates a new application or enhances the functionality of an existing application.",
        "A custom web design is the process of learning and understanding about your business, and applying a sound process of strategy, user experience, design execution, programming, and marketing to form a successful online business presence. Every aspect of your website is built specifically for your organizational goals.",
        " Digital Visiting card lets you automatically update the changes in your contact information, addresses, and vice versa. For easy access: You can get easy access to the visiting cards shared by others on your Smartphone anytime, anywhere & grow your business.",
        "Dynamic sites use server technologies, like PHP or JavaScript, for web development. These computer codes automatically create HTML and CSS “on the fly.” This means that when someone loads a dynamic web page, all the parts that make up that page will pull together and that is what is viewed",
        "A dynamic web page is a web page that displays different content each time it’s viewed. For example, the page may change with the time of day, the user that accesses the webpage, or the type of user interaction.",
        "Good e-commerce web design is all about using the right colors, fonts, images, words, and graphics to convince visitors to make a purchase. Your e-commerce website design should attract potential customers, provide a great user experience and present your shop in the best light.",
        "Ecommerce website design is the process of creating an online store for your business to sell digitally to target consumers. To design an e-commerce website, you need to plan, conceptualize, and arrange your content and products for effective display on the Internet.",
        "An E-learning web app is an interactive webpage that allows learners to input their data and get expected results through interactions. Your students can access the app from a web browser with an active internet connection from remote action.",
        "eLearning portals are flexible, online learning locations, usually separate from the learning management environment. They typically offer a variety of learning content including eLearning and bite-sized courses and resources.",
        "eCommerce promotion is when you offer sales and discounts to online shoppers in order to get new customers and increase revenue. And more importantly, these promotions can turn new visitors into loyal customers and repeat buyers. An eCommerce marketing strategy includes activities used both on and off your website.",
        "Educational software is a term used for any computer software which is made for an educational purpose. It encompasses different ranges from language learning software to classroom management software to reference software, etc.",
        "Web email and phone extractor is a versatile utility that takes care of the need for contacts. It can extract contacts from websites, whether it be email addresses or phone numbers, to give you the best result at a breakneck speed. This software can dig out thousands of contact details in a matter of minutes. It can dig out contacts from the given website, from links that lead to other websites from the given website, & even whole search engines based on the keywords fed in. The dig level can be set to decide the level up to which you want to take the extraction.",
        "Email marketing is a form of marketing that can make the customers on your email list aware of new products, discounts, and other services. It can also be a softer sell to educate your audience on the value of your brand or keep them engaged between purchases.",
        "Enterprise software, also known as enterprise application software (EAS), is computer software used to satisfy the needs of an organization rather than individual users.",
        "Facebook Lead Extractor tool is a very powerful web data scraping tool specially design for Facebook marketing with this software you can collect a business database of any targeted location",
        "Flutter is an open-source UI software development kit created by Google. It is used to develop cross platform applications for Android, iOS, Linux, Mac, Windows, Google Fuchsia, and the web from a single codebase.",
        "Google AdWords is a pay-per-click online advertising platform that allows advertisers to display their ads on Google’s search engine results page. Based on the keywords that want to target, businesses pay to get their advertisements ranked at the top of the search results page",
        "Google Business Extractor is a powerful tool that helps you to find business leads from Google Maps\n" +
                "\n" +
                "Demo of Google Business Extractor",
        "Hospital Management Software is any software item or system used within a medical context.",
        "A (hybrid app) is a software application that combines elements of both native apps and web applications. Hybrid apps are essentially web apps that have been put in a native app shell.",
        "This Product data pre-defined extractor is designed to scrape all detailed product information from indiamart.com categories listings. Each product will be saved as an individual row in your data file",
        "Ionic is an HTML5 mobile app development framework targeted at building hybrid mobile apps. Hybrid apps are essentially small websites running in a browser shell in an app that have access to the native platform layer.",
        "Design and develop advanced software applications. Build on one or more platforms which include but not limited to iOS,…\n" +
                "Communicate regularly and write clean code. Review, analyze and resolve application issues as needed.",
        "JustDial Data Extractor is the most powerful and easy-to-use data extraction software for web scraping and data extraction from Justdial websites. JustDial Data Extractor will benefit a wide range of computer users. Let’s say, for example, you need to extract all business (names, address, City, WhatsApp Contact no’s and Phone Numbers, etc.) from the JustDial website. It’s may save you plenty of effort and an endless string of browsing hours!",
        "A LinkedIn lead extractor is a software that speedily extracts data from LinkedIn. The list presents before you consist of your prospects’ business names, email addresses, contact numbers, Skype or Yahoo messenger IDs, company names, profession, etc.",
        "A laboratory management system (LMS), sometimes referred to as a laboratory information system (LIS) or laboratory management system (LMS), is a software-based solution with features that support a modern laboratory’s operations.",
        "Multi-Level Marketing (MLM) is a controversial marketing strategy for the sale of products or services where the revenue of the MLM company is derived from a non-salaried workforce selling the company’s products or services.",
        "Mobile app maintenance is the process in which the app developer ensures that the complete process of developing the app is bug-free. It envelopes many aspects like improvisations, fixation of the bugs and updating the different features.",
        "The mobile identification number (MIN) is a number that is derived from the 10-digit directory telephone number assigned to a mobile station.",
        "React Native is an open-source mobile application framework that can be used to develop applications for multiple platforms. The framework has been developed by Facebook. This framework basically allows developers to use React with platform capabilities that are native in nature",
        "A real estate portal is an online medium where anyone can list properties for sale through their site’s backend. Users can buy, rent, or lease real estate properties via an online real estate portal. Real estate web portal development gives an easy online way to connect sellers and buyers for streamlined operations.",
        "Sales are activities related to selling or the number of goods sold in a given targeted time period. The delivery of service for a cost is also considered a sale.\n" +
                "\n" +
                "Purchase is the process a business or organization uses to acquire goods or services to accomplish its goals.",
        "Search engine optimization (SEO) is the art and science of getting pages to rank higher in search engines such as Google. Because search is one of the main ways in which people discover content online, ranking higher in search engines can lead to an increase in traffic to a website.",
        "Extract premium unlimited individuals contacts from Linkedin, Facebook, Instagram & Twitter with no manual effort. It is one of the fastest software available in the market. Social Email Phone Extractor Pro is a tool that collects contact information such as Name, Email, Mobile & WhatsApp Number, and other important information from Source Site.",
        "The term social media marketing (SMM) refers to the use of social media and social networks to market a company’s products and services. Social media marketing provides companies with a way to engage with existing customers and reach new ones while allowing them to promote their desired culture, mission, or tone.",
        "Static website pages contain fixed HTML/CSS code and the content of each page does not change unless manually updated by the designer or webmaster. Static sites are the most basic type of website and they are built by creating a few HTML/CSS pages and uploading these to a web server.",
        "A Static Website is displayed in a web browser exactly as it is stored. It contains web pages with fixed content coded in HTML and stored on a web server. It does not change, it stays the same, or “static” for every viewer of the site.",
        "Social media optimization (SMO) is the use of social media networks to manage and grow an organization’s message and online presence. As a digital marketing strategy, social media optimization can be used to increase awareness of new products and services, connect with customers, and mitigate potential damaging news.",
        "Extract unlimited business/company contacts from public listings on the Tradeindia website with no manual effort. It is one of the fastest software available in the market by Marketing Software.",
        "A transportation management system (TMS) is a subset of supply chain management concerning transportation operations and may be part of an enterprise resource planning (ERP) system.",
        "A web portal is a secure web-based platform that gives access to varied functionality and content via an easy-to-navigate interface. ScienceSoft’s web portal development covers UX/UI design, web and mobile development, integrations, embedded analytics, testing, security, and continuous support."
    )

    val price = mutableListOf(
        "2499","2499","10000","2499",
        "3000","2499","15000","19999",
        "2499","1500","2499","15000",
        "2499","40000","20999","2499",
        "2499","2499","2499","2499",
        "2499","2499","2499","2499",
        "2499","2499","2499","3000",
        "2499","2499","3500","4000",
        "2499","2499","2499","2499",
        "2499","2499","2499","15000",
        "6000","2499","6000","2499",
        "8000","2499","2499","2499"
    )

    val highlights = mutableListOf(
        "Save time on admin tasks. …\n" +
                "Develop strong relationships with your guests. …\n" +
                "Increase your online visibility. …\n" +
                "Implement an effective revenue management system. …\n" +
                "Manage distribution functions. …\n" +
                "Increase bookings. …\n" +
                "Accurate daily reports.","","",
        "Email Verifiertool can intelligently verify bulk email addresses for marketing purposes.\n" +
                "The program checks email addresses against standard spelling rules.\n" +
                "Connect to the SMTP server and check the email address existence on it.\n" +
                "A domain is verified in the case of an incorrect domain, the email address will not exist.\n" +
                "Your mail will reach its destination.\n" +
                "Users can collect thousands of verified emails in one click.\n" +
                "Fast and easy mailing lists import from local files of different formats.\n" +
                "Unlimited email verification no limitation.\n" +
                "Multithreaded process for faster verification.\n" +
                "Automatic updates are with new features and settings instantly.\n" +
                "In the end, you will receive a list of verified emails.\n" +
                "The software can UPDATE automatically, which helps you to get new features.\n" +
                "The software has options to START – PAUSE – STOPin running mode.\n" +
                "Users can export collected data into CSV or excel file format.",
        "Get Business and/or Marketing Software.\n" +
                "\n" +
                "Tutorials included (English/Hindi)\n" +
                "Installation Support\n" +
                "Technical Support 10*6\n" +
                "100% Delivery On Number with reports\n" +
                "In-Built Filter\n" +
                "Live Demo available\n" +
                "Lowest Rate In Market\n" +
                " \n" +
                "\n" +
                "Buy Now or be behind of 13478+ business owners who took the decision earlier than you",
        "The company Leads Extractor tool can smartly collect bulk customer data for digital marketing purposes.\n" +
                "Extracts all email addresses and phone numbers from the source.\n" +
                "This extractor is the FASTEST Software available on the internet.\n" +
                "It is designed to extract email addresses and phone numbers with various criteria & various options to give the best results.\n" +
                "The extracted email addresses and phone numbers can be saved such as.CSV or excel files.\n" +
                "The extractor can UPDATE automatically, which helps you to get new features.\n" +
                "It can extract 1000 emails & phone numbers from multiple files in a minute.\n" +
                "Users can collect thousands of leads in one click.\n" +
                "Targeted search for email addresses & contact numbers using keywords & input files.\n" +
                "Unlimited data extraction no limitation at all.\n" +
                "Multithreaded process for faster intelligent extraction.\n" +
                "Automatic updates are with new features and settings instantly.\n" +
                "The software has options to START – PAUSE – STOPin running mode.\n" +
                "Users can export collected data into CSV or excel file format.",
        "Better knowledge of customers.\n" +
                "Better segmentation.\n" +
                "Better customer retention.\n" +
                "Better anticipation of needs.\n" +
                "Better and speedier communication.\n" +
                "Better protection of data privacy.",
        "Get A Unique & Innovative Product. …\n" +
                "Scale Your Organization Better. …\n" +
                "Improve Productivity & Employee Drive. …\n" +
                "Increase Your Return On Investment. …\n" +
                "Integrate Software With Other Programs. …\n" +
                "Receive Ongoing Technical Support.",
        "Website Design Tailored to Your Branding. …\n" +
                "Customer Experience-Optimized Design. …\n" +
                "Increased Search Engine Optimization. …\n" +
                "Ability to Evolve in Response to Business Changes. …\n" +
                "Flexibility with Hosting.",
        "1. Single Platform: Printed cards make up a heap in a few months so it becomes hard to find when required. It might get misplaced too as they are flooded like anything by the clients. It might also contain some irrelevant data.\n" +
                "\n" +
                "Environment-friendly: A Survey shows that 88% of printed cards handed out are thrown out in less than a week. Annually 50-60 billion cards are printed out of which 45-50 billion are thrown into landfills. These can be stopped by increasing the use of Digital Visiting cards. Save Trees, Save Environment, Become Environment- friendly.\n" +
                "Easy Updation: Another advantage of a Digital Visiting card is that it is easily updated. In the case of Printed cards, we need to Redesign and Reprint the cards which becomes difficult and expensive for small businesses. A Digital Visiting card lets you automatically update the changes in your contact information, addresses, and vice versa.\n" +
                "Easy Access: You can get easy access to the visiting cards shared by others on your Smartphone anytime, anywhere. Due to the Digital India Campaign, everyone is Digitizing themselves and so everyone can easily access the Digital cards.\n" +
                "Inexpensive: Digital cards are not required to be printed and designed, unlike paper cards. So, Digital Visiting cards are far cheaper if not inexpensive than paper cards.\n" +
                "Great First Impact: Digital Visiting cards allow you to attach videos and links which are related to your business. This helps in showing the whole story behind your brand. This creates a very good First Impression for your clients.\n" +
                "Time-Saving: Digital Business card saves a hell of a lot of time. One doesn’t have to search for a physical business card that might have been kept somewhere. Also, earlier people attended get-to-gathers just to collect business cards of the well-known businessman. But now this can be done sitting in your house or office, which saves much time."
                ,"Easy Updating: The biggest advantage of a Dynamic Website is that it can be easily updated as per the needs of the owner of the website.\n" +
                "User Friendly: Dynamic websites are very user-friendly.\n" +
                "Professional Look.\n" +
                "Easily Manageable",
        "Easy Updating: The biggest advantage of a Dynamic Website is that it can be easily updated as per the needs of the owner of the website.\n" +
                "User Friendly: Dynamic websites are very user-friendly.\n" +
                "Interactive.\n" +
                "Professional Look.\n" +
                "Easily Manageable.",
        "Optimal User Experience.\n" +
                "Flexible Site Management.\n" +
                "Improved Brand Reputation.\n" +
                "Increased Invisibility.\n" +
                "Higher Conversion Rates",
        "Selling can be centered around the Global client\n" +
                "Pre-deals, subcontracts, and supply\n" +
                "Financing and protection\n" +
                "Commercial exchanges, requesting, conveyance installment\n" +
                "Product administration and support\n" +
                "Cooperative item improvement\n" +
                "Distributive co-employable working\n" +
                "Use of open and private administrations\n" +
                "Business to an organization (client)\n" +
                "Transport and coordinations\n" +
                "Public acquisition\n" +
                "Automatic exchanging of computerized merchandise",
        "Online Learning Accommodates Everyone’s Needs. The online method of learning is best suited for everyone.\n" +
                "Lectures Can Be Taken Any Number Of Times.\n" +
                "Offers Access To Updated Content.\n" +
                "Quick Delivery Of Lessons.\n" +
                "Reduced Costs.",
        "Online Learning Accommodates Everyone’s Needs. The online method of learning is best suited for everyone.\n" +
                "\n" +
                "Lectures Can Be Taken Any Number Of Times.\n" +
                "\n" +
                "Offers Access To Updated Content.\n" +
                "\n" +
                "Quick Delivery Of Lessons.\n" +
                "\n" +
                "Scalability.\n" +
                "\n" +
                "Consistency.\n" +
                "\n" +
                "Reduced Costs.\n" +
                "\n" +
                "Effectiveness.\n" +
                "\n",
        "Increased Customer Reach. …\n" +
                "No Time Restrictions. …\n" +
                "Low Start-Up and Running Costs. …\n" +
                "Run Your Business from Anywhere. …\n" +
                "Measurement, reporting, and responding to opportunities",
        "1. Organizing Content And Giving Access To It. You can store all the materials and structure them in one safe place. This way, you keep all the vital …\n" +
                "2. Tracking Student Progress And Behavior.\n" +
                "3. Education Cost Reduction.\n" +
                "4. Reduced Teacher Workload.\n" +
                "5. Enhanced Student Engagement And Performance.",
        "Email & Phone Extractor Webtool can smartly collect bulk customer data for digital marketing purposes.\n" +
                "Extracts all email addresses and phone numbers from source websites & keyword basis.\n" +
                "This extractor is the FASTEST Software available on the internet.\n" +
                "It is designed to extract email addresses and phone numbers with various criteria & various options to give the best results.\n" +
                "The extracted email addresses and phone numbers can be saved such as.CSV files.\n" +
                "The extractor can UPDATE automatically, which helps you to get new features.\n" +
                "It can extract 10000 emails & phone numbers from multiple websites in a minute.\n" +
                "Users can collect thousands of leads in one click.\n" +
                "Targeted search for email addresses & contact numbers using keywords.\n" +
                "Unlimited data extraction no limitation at all.\n" +
                "Multithreaded process for faster intelligent extraction.\n" +
                "Automatic updates are with new features and settings instantly.\n" +
                "In the end, you will receive a list of extracted leads from the website.\n" +
                "The software has options to START – PAUSE – STOPin running mode.\n" +
                "Users can export collected data into CSV or excel file format.",
        "Low costs. One of the most obvious advantages of email marketing is its lower cost compared to mainstream marketing channels. …\n" +
                "Reach an already engaged audience. …\n" +
                "Deliver targeted messages. …\n" +
                "Drive revenue. …\n" +
                "Easy to get started. …\n" +
                "Easy to measure. …\n" +
                "Easy to share. …\n" +
                "Reach a global audience",
        "Faster. No one likes to deal with a business that takes its sweet time responding to the needs of its customers.\n" +
                "\n" +
                "Efficient. Using software to get things done faster is not just smart, it’s more efficient. Humans make mistakes.\n" +
                "\n" +
                "Improves Interactions. No matter how automated your business may be, you can’t overlook the quality and efficiency.\n" +
                "\n" +
                "Eliminates the Fat. Keeping your operations lean is hard work. It requires you to constantly be aware of each employee.",
        "Facebook Lead Extractor software can intelligently collect bulk data from the source site.\n" +
                "\n" +
                "Users can get millions of real-time & fresh data from the source site.\n" +
                "\n" +
                "Extracts all email addresses and phone numbers from the source site for business purposes.\n" +
                "\n" +
                "The software has both b2c and b2b data extraction modes for targeted customers & business data.\n" +
                "\n" +
                "This extractor is the FASTEST Software available on the internet.\n" +
                "\n" +
                "Users can add multiple locations and multiple keywords at the same time.\n" +
                "\n" +
                "The software can extract data with the basis of location(state-Pincode-city-country) & keywords.\n" +
                "\n" +
                "It is designed to extract email addresses and phone numbers with various categories & keywords.\n" +
                "\n" +
                "The extracted email addresses and phone numbers can be saved automatically in excel file format.\n" +
                "\n" +
                "The software will update automatically when new features came.\n" +
                "\n" +
                "Unlimited data extraction no limitation at all.\n" +
                "\n" +
                "Multithreaded process for faster extraction.\n" +
                "\n" +
                "The software has options to START – PAUSE – STOP in running mode.",
        "Cross-Platform Capability\n" +
                "A Fast Rising and Supportive Community\n" +
                "Fast and Simple App Development\n" +
                "Open Source Project\n" +
                "A Collection of Amazing Widgets\n" +
                "Simple to Learn\n" +
                "Beyond Mobile Applications\n" +
                "Editor and Design Tools",
        "1) Adwords works faster than SEO.\n" +
                "2) Increase brand awareness.\n" +
                "3) Reach more customers through their Gmail Inbox.\n" +
                "4) Reconnect with visitors to your website.\n" +
                "5) Measure your performance consistently.\n" +
                "6) Explore more using your ads.\n" +
                "7) Tackle your competition better.\n" +
                "Go to Chapter Three.",
        "G-Business Extractor is a powerful tool that helps you to find business leads from Google Maps\n" +
                "\n" +
                "Google Maps is a source where you can find millions of business leads classifieds by categories and locations.\n" +
                "You can search by your target keywords in your locations. This software will search and find business information like website, email addresses, phone, fax, etc.\n" +
                "\n" +
                "The excellent Local Business Extractor has been created to beat any competitor with its powerful features:\n" +
                "\n" +
                "Extract Data (e-mail addresses, phone, fax, business name, etc) from the Google Maps directory in seconds with just one click.\n" +
                "> Users can search in any category and location.\n" +
                "> Support proxies for connection. > Automatic updates when sources sites change.\n" +
                "> Export results to CSV or XLS\n" +
                "\n" +
                "Free support and updates for 1 Year from Marketing Software Team.\n" +
                "\n" +
                "Choose the best products at the best price with the best after service only from MARKETING SOFTWARE.",
        "standalone software used for diagnostic or therapeutic purposes.\n" +
                "software embedded in a medical device (often referred to as “medical device software”).\n" +
                "software that drives a medical device or determines how it is used.\n" +
                "software that acts as an accessory to a medical device.\n" +
                "software used in the design, production, and testing of a medical device.\n" +
                "software that provides quality control management of a medical device.",
        "Allows the reuse of code saving developers time enough.\n" +
                "Its investment cost is lower than native.\n" +
                "No matter what operating system you use it, the functions will be the same.\n" +
                "It has a good performance on any platform.\n" +
                "Its maintenance is less complicated than the native ones.\n" +
                "Hybrid App Development quantity-\n",
        "Indiamart Lead Extractor software can intelligently collect bulk data from the source site.\n" +
                "\n" +
                "Users can get millions of real-time & fresh data from the source site.\n" +
                "\n" +
                "Extracts all email addresses and phone numbers from the source site.\n" +
                "\n" +
                "This extractor is the FASTEST Software available on the internet.\n" +
                "\n" +
                "Users can add multiple locations and multiple keywords at the same time.\n" +
                "\n" +
                "It is designed to extract email addresses and phone numbers with various categories & keywords.\n" +
                "\n" +
                "The extracted email addresses and phone numbers can be saved automatically in excel file format.\n" +
                "\n" +
                "The software will update automatically when new features came.\n" +
                "\n" +
                "Unlimited data extraction no limitation at all.\n" +
                "\n" +
                "Multithreaded process for faster extraction.\n" +
                "\n" +
                "The software has options to START – PAUSE – STOP in running mode.",
        "Developer-friendly\n" +
                "\n" +
                "Equipped with an entire suite of tools, with native compatibility\n" +
                " Front-end agnostic\n" +
                "Trusted by companies small and large\n" +
                "Fueled by a developer-centric community",
        "Great Security: iPhone app development for businesses requires adherence to high-quality standards of Apple’s App Store.\n" +
                "Amazing User Experience: The inherent capabilities of Apple iOS offer an excellent user experience.\n" +
                "Simpler Yet Effective Testing Practices: Apple has a lesser number of devices in the market, and therefore the versions.",
        "JustDial Data Extractor is the most powerful and easy-to-use data extraction software for web scraping and data extraction from Justdial websites. JustDial Data Extractor will benefit a wide range of computer users. Let’s say, for example, you need to extract all business (names, address, City, WhatsApp Contact no’s and Phone Numbers, etc.) from the JustDial website. It’s may save you plenty of effort and an endless string of browsing hours!\n" +
                "\n" +
                "JustDial Data Extractor features:-\n" +
                "\n" +
                "✅ User-friendly interface\n" +
                "\n" +
                "✅ Single-click data extraction process\n" +
                "\n" +
                "✅ No need for any programming skill\n" +
                "\n" +
                "✅ Extract Data From JustDial Website.\n" +
                "\n" +
                "✅ Save your browsing hours.\n" +
                "\n" +
                "✅ Extract Name, Address, WhatsApp Number, Phone Numbers, Email ID, Categories, Websites, State, City. Pin code..etc\n" +
                "\n" +
                "✅ Extract Data By Keywords / URL based ( Unlimited ).\n" +
                "\n" +
                "✅ Save or Export data to Microsoft Excel File.\n" +
                "\n" +
                "✅ Extracted data stored in CSV format, which can easily be opened in Excel.\n" +
                "\n" +
                "✅ See the total extracted records and view the results.\n" +
                "\n" +
                "✅ One year License.\n" +
                "\n" +
                "✅ Free On-demand One Time Installation Live Support.\n" +
                "\n" +
                "Extract unlimited business/company contacts from public listings on the Justdial website with no manual effort. It is one of the fastest software available in the market.\n" +
                "\n" +
                "Free support and updates for 1 Year from Marketing Software Team.\n" +
                "\n" +
                "Choose the best products at the best price with the best after service only from MARKETING SOFTWARE.\n",
        "Inexpensive – Web scraping services provide an essential service at a low cost. It is paramount that data is collected back from websites and analyzed so that the internet functions regularly. Web scraping services do the job in an efficient and budget friendly manner.\n" +
                "Easy to implement – Once a web scraping services deploys the proper mechanism to extract data, you are assured that you are not only getting data from a single page but from the entire domain. This means that with just a onetime investment, a lot of data can be collected.\n" +
                "Low maintenance and speed– One aspect that is often overlooked when installing new services is the maintenance cost. Long term maintenance costs can cause the project budget to spiral out of control. Thankfully, web scraping technologies need very little to no maintenance over a long period. Another characteristic that must also be mentioned is the speed with which web scraping services do their job. A job that could take a person week is finished in a matter of hours.\n" +
                "Accuracy – The web scraping services are not only fast, they are accurate too. Simple errors in data extraction can cause major mistakes later on. Accurate extraction of any type of data is thus very important.In websites that deal in pricing data, sales prices, real estate numbers or any kind of financial data, the accuracy is extremely important.",
        "The same underlying software for all customers, allowing simple upgrades without reconfiguration\n" +
                "Configuration changes are held in the LIMS database\n" +
                "Configure once for both desktop and web applications\n" +
                "No software coding (C, HTML, Java etc.) skills are required",
        "A multi-level marketing system or MLM software services contain a holistic set of tools that are required to manage and organize MLM accounts. There are several advanced MLM website software available in the market, and the choice of the software should be based on organizational budget, goals, and objectives.",
        "",
        "Mobile Number Lookup tool can intelligently check network provider name, state for marketing purposes.\n" +
                "This software helps you for targeted based marketing purposes.\n" +
                "This software is the FASTEST Software available on the internet.\n" +
                "Users can check thousands of mobile numbers in one click.\n" +
                "The phone numbers details can be saved such as.CSV files.\n" +
                "The software can UPDATE automatically, which helps you to get new features.\n" +
                "Unlimited data verification has no limitation at all.\n" +
                "Multithreaded process for faster verification.\n" +
                "Get a clear idea after identifying from which number you’re likely getting a response for more engagement.\n" +
                "If you wish to promote your company in a particular region or area then target easily with this service.\n" +
                "The software has options to START – PAUSE – STOPin running mode.",
        "It’s cheap\n" +
                "Speedup development\n" +
                "It uses JavaScript\n" +
                "Requires a small dev team to start\n" +
                "It is open-source\n" +
                "It provides hot reloading\n" +
                "It has a large developer community\n" +
                "The performance is great\n" +
                "The look and feel is amazing\n" +
                "It works with a modular architecture",
        "Listing feature properties to get more leads\n" +
                "\n" +
                "Customized search option in finding genuine properties\n" +
                "\n" +
                "Admin to control listing, managing, and updating property listing\n" +
                "\n" +
                "Secure login and account set up for sellers, buyers, agents, admin, managers, and employees\n" +
                "\n" +
                "Payment management\n" +
                "\n" +
                "Property by types (selling, renting, and leasing)\n" +
                "\n" +
                "Properties by locations\n" +
                "\n" +
                "Social integration platform\n" +
                "\n" +
                "Strong marketing and advertising platform\n" +
                "\n" +
                "Database management",
        "Listing feature properties to get more leads\n" +
                "\n" +
                "Customized search option in finding genuine properties\n" +
                "\n" +
                "Admin to control listing, managing, and updating property listing\n" +
                "\n" +
                "Secure login and account set up for sellers, buyers, agents, admin, managers, and employees\n" +
                "\n" +
                "Payment management\n" +
                "\n" +
                "Property by types (selling, renting, and leasing)\n" +
                "\n" +
                "Properties by locations\n" +
                "\n" +
                "Social integration platform\n" +
                "\n" +
                "Strong marketing and advertising platform\n" +
                "\n" +
                "Database management",
        "SEO Is A Long-term Marketing Strategy\n" +
                "You Can Generate More Quality Leads.\n" +
                "You Don’t Have To Pay To Rank Organically.\n" +
                "People Trust Organic Results.\n" +
                "You Can Stay Ahead Of The Competition.\n" +
                "You Can Measure Seo Results.\n" +
                "Provides Better User Experience.",
        "Social Email Phone Extractor Pro software can intelligently collect bulk data from the source site.\n" +
                "Users can get millions of real-time & fresh data from LinkedIn, Facebook, Instagram & Twitter.\n" +
                "Extracts all email addresses and phone numbers from the source site.\n" +
                "This extractor is the FASTEST Software available on the internet.\n" +
                "Users can add multiple locations and multiple keywords at the same time.\n" +
                "It is designed to extract email addresses and phone numbers with various categories & keywords.\n" +
                "The extracted email addresses and phone numbers can be saved automatically in excel file format.\n" +
                "The software will update automatically when new features came.\n" +
                "Unlimited data extraction no limitation at all.\n" +
                "Multithreaded process for faster intelligent extraction.\n" +
                "The software has options to START – PAUSE – STOPin running mode.",
        "Create Brand Recognition. …\n" +
                "Increases Sales. …\n" +
                "Measuring Success with Analytics. …\n" +
                "Discover How To Connect With Your Audience Using Social Listening. …\n" +
                "Cost-Effective. …\n" +
                "Helps you get Marketplace insights. …\n" +
                "Higher Conversion Rate. …\n" +
                "Better Customer Satisfaction",
        "quick and easy to develop.\n" +
                "cheap to develop.\n" +
                "cheap to host.\n" +
                "cost-effective.",
        "Provide improved security.\n" +
                "Improved performance for end-users compared to dynamic websites.\n" +
                "Fewer or no dependencies on systems such as databases or other application servers.",
        "Traffic: Apart from search engines and email marketing, the top source of traffic is SMO. If done virtually, you can expect huge traffic on your website.\n" +
                "Website visibility: As you know, a big number of people use social networking websites, forums, and online communities; SMO helps you to increase website visibility.\n" +
                "Communication channel: Now a day, companies provide their customers a business channel (apart from traditional email and call support) such as a Facebook page, so that the customers can easily reach them and they can have a great connection.\n" +
                "Free advertisement: Social media platforms are being proven as a great source of advertisement.\n" +
                "Ease of target: With social media platforms and online communities, you can even advertise to a limited audience. Or, if your business covers the worldwide audience, then it becomes much easier to reach the global audience with SMO services.\n" +
                "Customer satisfaction: If a customer contacts you via your Social Media channel and gets an immediate response then it helps to increase the customer satisfaction rate while increasing credibility as well.\n" +
                "Sharing quick updates: If you want to announce the launch of a new product, a press release, or important information that should reach your customers, then SMO provides you a superb platform in form of a Facebook page, Twitter, etc.\n" +
                "Paid options: While SMO provides several free options like blogging, forum posting, etc you have several paid options to reach the targeted audience. For example, Facebook Ads, Twitter Ads, Linkedin Ads, StumbleUpon Ads, etc. While these are paid options, they are also cost-effective in comparison to the success rate.\n" +
                "Close relationship with customers: When you update something on your Facebook page, Twitter handle, or any other such platform, then your customers share their views, which helps to understand what your customers need. So, it helps to build trust and a strong relationship while giving you chance for betterment.\n" +
                "Quick Popularity: If you need quick popularity then you either need to take help of Television Advertisement or SMO Services. With help of SMO, you can get quick popularity.",
        "TradeIndia Extractor Tool can Intelligently Collect Bulk Customer Data for Digital Marketing Purpose.\n" +
                "Users Can Collect Thousands of Leads in One Click.\n" +
                "Targeted Search for Contact Number Using Keywords.\n" +
                "No Need to Wait For One Process to Complete to Start Another.\n" +
                "In The End, You Will Receive a List of Extracted Leads From Websites.\n" +
                "The Software Has Options to Start – Pause – Stop in Running Mode.\n" +
                "Users Can Export Collected Data into CSV File Format.\n" +
                "TradeIndia Lead Extractor tool can intelligently collect bulk customer data for digital marketing purposes.\n" +
                "Extracts all phone numbers from the source site\n" +
                "This extractor is the FASTEST Softwareavailable on the internet.\n" +
                "It is designed to extract phone numbers with various criteria & various options to give the best results.\n" +
                "The extracted phone numbers can be saved such as.CSV files.\n" +
                "The extractor can UPDATE automatically, which helps you to get new features.\n" +
                "Users can collect thousands of leads in one click.\n" +
                "Targeted search for contact numbers using keywords.\n" +
                "Unlimited data extraction no limitation.\n" +
                "Multithreaded process for faster extraction.\n" +
                "Automatic updates with new features and settings.\n" +
                "In the end, you will receive a list of extracted leads from the website.\n" +
                "Users can export collected data into CSV file format.\n" +
                "Tradindia Lead Extractor quantity-\n",
        "TradeIndia Extractor Tool can Intelligently Collect Bulk Customer Data for Digital Marketing Purpose.\n" +
                "Users Can Collect Thousands of Leads in One Click.\n" +
                "Targeted Search for Contact Number Using Keywords.\n" +
                "No Need to Wait For One Process to Complete to Start Another.\n" +
                "In The End, You Will Receive a List of Extracted Leads From Websites.\n" +
                "The Software Has Options to Start – Pause – Stop in Running Mode.\n" +
                "Users Can Export Collected Data into CSV File Format.\n" +
                "TradeIndia Lead Extractor tool can intelligently collect bulk customer data for digital marketing purposes.\n" +
                "Extracts all phone numbers from the source site\n" +
                "This extractor is the FASTEST Softwareavailable on the internet.\n" +
                "It is designed to extract phone numbers with various criteria & various options to give the best results.\n" +
                "The extracted phone numbers can be saved such as.CSV files.\n" +
                "The extractor can UPDATE automatically, which helps you to get new features.\n" +
                "Users can collect thousands of leads in one click.\n" +
                "Targeted search for contact numbers using keywords.\n" +
                "Unlimited data extraction no limitation.\n" +
                "Multithreaded process for faster extraction.\n" +
                "Automatic updates with new features and settings.\n" +
                "In the end, you will receive a list of extracted leads from the website.\n" +
                "Users can export collected data into CSV file format.\n" +
                "Tradindia Lead Extractor quantity-\n" +
                "1\n" +
                "+ADD TO CART\n" +
                "Category: Data Extractor\n" +
                "Tag: Data Extractor\n",
        "save time by consolidating back-end applications into one point of access.\n" +
                "increase security by providing a single sign-on for all business applications.\n" +
                "promote products to customers in a consistent way, with tailored branding."
    )


}
