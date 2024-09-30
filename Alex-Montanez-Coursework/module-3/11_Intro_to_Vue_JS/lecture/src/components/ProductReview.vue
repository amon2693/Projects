<template>
    <div class="main" style="border: solid black;">
        <h2>Product Reviews for {{ name }}</h2>

        <p class="description">{{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>

            <div class="well">
                <span class="amount"><!-- data in here--></span>
                1 Star Reviews
            </div>

            <div class="well">
                <span class="amount"><!-- data in here--></span>
                2 Star Reviews
            </div>

            <div class="well">
                <span class="amount"><!-- data in here--></span>
                3 Star Reviews
            </div>

            <div class="well">
                <span class="amount"><!-- data in here--></span>
                4 Star Reviews
            </div>

            <div class="well">
                <span class="amount"><!-- data in here--></span>
                5 Star Reviews
            </div>
        </div>

        <div class="review" v-for="review in reviews" v-bind="review.id">
            <h4>{{ review.reviewer }}</h4>
            <div class="rating">
                <img src="../assets/star.png" 
                v-for="n in review.rating"
                 v-bind:key="n"
                 v-bind:title="review.rating + ' Star Review '" />
            </div>
            <h3>{{ review.title }}</h3>
            <p>{{ review.review }}</p>
        </div>

    </div>
</template>

<script>
export default {
    name: 'product-review',
    data() {
        return {
            name: 'Head First Design Patterns',
            description: 'A brain friendly guide to building extensible and maintainable object-oriented software.',
            reviews: [
        {
          id: 1000,
          reviewer: 'R Pérez',
          title: 'Approachable pattern guide',
          review:
            'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
          rating: 4,
          favorited: false
        },
        {
          id: 1001,
          reviewer: 'Carmen',
          title: 'Pattern complexity gone!',
          review:
            'I struggled for years to understand patterns and how to implement the design and how them. This is by far the best book to learn design patterns. I would give this 10 stars if I could.',
          rating: 5,
          favorited: false
        },
        {
          id: 1002,
          reviewer: 'J. King',
          title: 'Not for me',
          review:
            'The content is thorough and well described. However, the format just doesn\'t work for me. I need something more traditional.',
          rating: 1,
          favorited: false
        },
        {
          id: 1003,
          reviewer: 'Safa H.',
          title: 'Good for beginners',
          review:
            'Good introduction to design patterns especially if you have never used them before or are relatively new to OO principles.',
          rating: 3,
          favorited: false
        },
        {
          id: 1004,
          reviewer: 'L Wang',
          title: 'Entertaining',
          review:
            'If you are new to design patterns I HIGHLY recommend this book. You might think it\'s not "serious enough" at first. But as you go through it things just stick. It makes learning enjoyable.',
          rating: 4,
          favorited: false
        }
      ]
        }
    },
    computed: {
        averageRating() {
            if(this.reviews.length === 0) {
                return 0;
            }

            let sum = this.rewiews.reduce((currentSum, review) => {
                return currentSum + review.rating;
            });

            return sum / this.reviews.length;
        }
    }
}
</script>

<style scoped>
div.main {
    margin: 1 rem 0;
    .well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}
.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

.favorited {
  background-color: lightyellow;
}

.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

.rating img {
  height: 100%;
}

.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
.review p {
  margin: 20px;
}

.review h3 {
  display: inline-block;
}

.review h4 {
  font-size: 1rem;
}
}

</style>