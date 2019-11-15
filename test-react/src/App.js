import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    isLoading: true,
    companies: []
  };

  async componentDidMount() {
    const response = await fetch('/api/companies');
    const body = await response.json();
    this.setState({ companies: body, isLoading: false });
  }

  render() {
    const {companies, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>JUG List</h2>
            {companies.map(company =>
              <div key={company.id}>
                {company.name}
              </div>
            )}
          </div>
        </header>
      </div>
    );
  }
}

export default App;