# URL Shortener Project
A simple URL Shortener system built with Java that allows users to shorten long URLs, track statistics, and manage link expiration. This system stores the mappings between long and short URLs in a CSV file and supports basic analytics.
# Project Overview
The URL Shortener project is designed to transform long URLs into shorter, manageable links using Base62 encoding. It supports:
Shortening URLs: Generates unique short codes for any valid URL.
Link Redirection: Redirects users to the original long URL.
Data Storage: Stores mappings in a CSV file (urls.csv).
Statistics Tracking: Monitors how often each URL is accessed.
Expiration Management: Supports automatic link expiration.
Validation: Ensures only valid URLs can be shortened.
