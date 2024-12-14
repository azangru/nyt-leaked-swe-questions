import React from 'react';
import Board from 'react-trello';
import FilterSelector from './FilterSelector'
import Tasks from './Tasks'
import './App.css';

class App extends React.Component {
  constructor(props) {
    super(props);

    // Init the state of the app with the default catagory lanes and cards
    this.state = {
      lane: 'all',
      allTasks: Tasks,
      filteredTasks: Tasks
    };

    // Bind the filter event
    this.filterTasks = this.filterTasks.bind(this);
    this.onSelectLaneFilter = this.onSelectLaneFilter.bind(this);
  }

  /**
   * A method to quickly filter and show tasks by a given filter
   * @param {String} filter - a label representing the id of a given task
   * @returns {Object} tasks - the object representing the tasks
   * @see tasks.json
   */
  filterTasks() {
    const { lane, allTasks } = this.state;
    if (lane === 'all') {
      return this.setState({
        filteredTasks: allTasks
      });
    }

    /**
     * Your solution goes here... 🔥
     */
  }

  /**
   * A handler for when dropdown values change from the FilterSelector component
   * @param {Object} e - the value change event from the dropdown menu
   */
  onSelectLaneFilter(e) {
    this.setState({
      lane: e
    }, () => this.filterTasks());
  }

  render() {
    const { filteredTasks } = this.state;
    return (
      <div className="App">
        {/* Trello like board */}
        <Board data={filteredTasks} />

        {/* Filter for lists */}
        <FilterSelector
          onSelectChange={this.onSelectLaneFilter}
          values={['backlog', 'progres', 'blocked', 'complete']}
        />
      </div>
    );

  }
}

export default App;
