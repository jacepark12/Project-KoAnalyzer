sentiment_csv = read.csv("/Users/parkjaesung/Documents/Github/Project-Kopinion/Project-Kopinion/Kopinion-TestModule/src/main/resources/OutPutResources/SummaryGraph.csv", header = T)

names(sentiment_csv) = c("0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100")

sentiment_matrix = as.matrix(sentiment_csv)

barplot(sentiment_matrix,
        col = c("blue","red","gray"),
        xlab = "Position in Text",
        ylab = "Number of Sentiment Words")