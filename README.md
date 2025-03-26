# URL Shortener Project
A simple URL Shortener system built with Java that allows users to shorten long URLs, track statistics, and manage link expiration. This system stores the mappings between long and short URLs in a CSV file and supports basic analytics.
# Project Overview
The URL Shortener project is designed to transform long URLs into shorter, manageable links using Base62 encoding. It supports:<br />
• Shortening URLs with unique short codes.<br/>
• Storing and retrieving URLs from a CSV file.<br/>
• Redirecting short URLs to the original link.<br/>
• Tracking analytics such as usage statistics.<br/>
• Managing link expiration.<br/>
# How It Works
**Shorten a URL**.<br/>
• Input a valid URL..<br/>
• Generates a unique Base62 code..<br/>
• Saves the mapping to urls.csv..<br/>

**Redirect to Original URL**<br/>
• Enter a short URL.<br/>
• Retrieves and returns the original long URL.<br/>

**Track Statistics**<br/>
• Counts how many times each shortened URL is accessed.<br/>

**Manage Expiration**<br/>
• Automatically removes expired links from the system.<br/>
